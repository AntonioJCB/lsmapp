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
import com.example.lsmapp.components.BottomNavBar
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.LessonScreen
import com.example.lsmapp.screens.ProfileScreen
import com.example.lsmapp.screens.RankingScreen
import com.example.lsmapp.screens.SenasScreen

@Composable
fun MainScaffold(onLogoutClick: () -> Unit, onNavigateToAuth: () -> Unit) {
    val nav = rememberNavController()

    Scaffold(
        containerColor = Color(0xFF47525E), // Fondo oscuro del scaffold
        bottomBar = { BottomNavBar(navController = nav) }
    ) { innerPadding ->
        NavHost(
            navController = nav,
            startDestination = Route.Lesson.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Route.Lesson.route) { LessonScreen(navController = nav) }
            composable(Route.Senas.route) { SenasScreen() }
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
