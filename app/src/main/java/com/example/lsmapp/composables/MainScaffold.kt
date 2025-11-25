package com.example.lsmapp.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lsmapp.components.BottomNavBar
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.LessonScreen
import com.example.lsmapp.screens.ProfileScreen
import com.example.lsmapp.screens.RankingScreen
import com.example.lsmapp.screens.SenasScreen
import com.example.lsmapp.senas.SenasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(mainNavController: NavHostController) { // Accept the main NavController
    val innerNavController = rememberNavController() // A new NavController for the bottom bar
    val currentRoute = currentRoute(innerNavController)

    // Crear el ViewModel aquí para compartirlo
    val senasViewModel: SenasViewModel = viewModel()

    val title = when (currentRoute) {
        Route.Lesson.route -> "Temas"
        Route.Senas.route -> "Señas"
        Route.Ranking.route -> "Ranking"
        Route.Profile.route -> "Usuario"
        else -> ""
    }

    Scaffold(
        containerColor = Color(0xFF47525E),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF47525E),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = { BottomNavBar(navController = innerNavController) } // Use the inner NavController for the bar
    ) { innerPadding ->
        NavHost(
            navController = innerNavController, // This NavHost also uses the inner controller
            startDestination = Route.Lesson.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Pass the MAIN NavController to the screens that need to navigate outside the scaffold
            composable(Route.Lesson.route) { LessonScreen(navController = mainNavController) }
            composable(Route.Senas.route) { SenasScreen(viewModel = senasViewModel) }
            composable(Route.Ranking.route) { RankingScreen() }
            composable(Route.Profile.route) { ProfileScreen() }
        }
    }
}

@Composable
private fun currentRoute(nav: NavHostController): String? {
    val backStackEntry by nav.currentBackStackEntryAsState()
    return backStackEntry?.destination?.route
}