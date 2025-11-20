package com.example.lsmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lsmapp.composables.MainScaffold
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.LoginScreen
import com.example.lsmapp.screens.RegisterScreen
import com.example.lsmapp.ui.theme.LsmappTheme
import com.example.lsmapp.viewModel.AppViewModel

class MainActivity : ComponentActivity() {

    private val vm: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LsmappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppRoot(
                        modifier = Modifier.padding(innerPadding),
                        vm = vm
                    )
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        // Solo cierra la sesión si la app se detiene y no es por un cambio de configuración
        if (!isChangingConfigurations) {
            vm.logout()
        }
    }
}

@Composable
fun AppRoot(modifier: Modifier = Modifier, vm: AppViewModel) {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Route.Auth.route) {

        // Flujo de autenticación
        composable(Route.Auth.route) {
            AuthNavHost(
                onLoggedIn = {
                    vm.login()
                    nav.navigate(Route.Main.route) {
                        // Limpia el backstack hasta la ruta de autenticación
                        popUpTo(Route.Auth.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        // Flujo principal de la app
        composable(Route.Main.route) {
            MainScaffold(
                onLogoutClick = {
                    vm.logout()
                    // Limpia toda la pila de navegación y vuelve a la autenticación
                    nav.navigate(Route.Auth.route) { popUpTo(0) }
                },
                onNavigateToAuth = {
                    vm.logout()
                    nav.navigate(Route.Auth.route) { popUpTo(0) }
                }
            )
        }
    }
}

@Composable
fun AuthNavHost(onLoggedIn: () -> Unit) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Route.Login.route) {
        composable(Route.Login.route) {
            LoginScreen(
                onNavigateToHome = { onLoggedIn() },
                onNavigateToRegistration = { nav.navigate(Route.Register.route) }
            )
        }
        composable(Route.Register.route) {
            RegisterScreen(
                onNavigateToHome = { onLoggedIn() },
                onNavigateToLogin = { nav.popBackStack() }
            )
        }
    }
}
