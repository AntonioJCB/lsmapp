package com.example.lsmapp.composables
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lsmapp.components.NavBar
import com.example.lsmapp.components.NavBarItem
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.LessonScreen
import com.example.lsmapp.screens.ProfileScreen
import com.example.lsmapp.screens.SenasScreen

@Composable
fun MainScaffold(onLogoutClick: () -> Unit, onNavigateToAuth: () -> Unit) {
    val nav = rememberNavController()
    
    // Obtener la ruta actual para sincronizar el NavBar
    val currentRoute = currentRoute(nav)
    val selectedNavItem = when (currentRoute) {
        Route.Lesson.route -> NavBarItem.LIST
        Route.Senas.route -> NavBarItem.SIGNS
        Route.Profile.route -> NavBarItem.PROFILE
        else -> NavBarItem.LIST
    }

    Scaffold(
        containerColor = Color(0xFF47525E), // Fondo oscuro del scaffold
        bottomBar = {
            NavBar(
                selectedItem = selectedNavItem,
                onItemSelected = { item ->
                    val destination = when (item) {
                        NavBarItem.LIST -> Route.Lesson.route
                        NavBarItem.SIGNS -> Route.Senas.route
                        NavBarItem.PROFILE -> Route.Profile.route
                    }
                    if (currentRoute != destination) {
                        nav.navigate(destination) {
                            launchSingleTop = true
                            // Evitar múltiples copias en el back stack
                            popUpTo(Route.Lesson.route) { saveState = true }
                            restoreState = true
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = nav,
            startDestination = Route.Lesson.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Route.Lesson.route) { LessonScreen(navController = nav) }
            composable(Route.Senas.route) { SenasScreen() }
            composable(Route.Profile.route) { ProfileScreen() }
        }
    }
}

@Composable
private fun currentRoute(nav: NavHostController): String? {
    val backStackEntry by nav.currentBackStackEntryAsState()
    return backStackEntry?.destination?.route
}
