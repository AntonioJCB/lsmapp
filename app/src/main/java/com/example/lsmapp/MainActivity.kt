package com.example.lsmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lsmapp.composables.MainScaffold
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.Lessons.CongratulationsScreen
import com.example.lsmapp.screens.Lessons.LessonDetailScreen
import com.example.lsmapp.screens.Lessons.CongratulationsScreen
import com.example.lsmapp.screens.Lessons.LessonDetailScreen
import com.example.lsmapp.screens.Lessons.QuizScreen
import com.example.lsmapp.screens.LoginScreen
import com.example.lsmapp.screens.RegisterScreen
import com.example.lsmapp.ui.theme.LsmappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LsmappTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.Login.route) {
        composable(Route.Login.route) {
            LoginScreen(
                onNavigateToHome = { 
                    navController.navigate(Route.Main.route) {
                        popUpTo(Route.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegistration = { navController.navigate(Route.Register.route) }
            )
        }
        composable(Route.Register.route) {
            RegisterScreen(
                onNavigateToHome = { 
                    navController.navigate(Route.Main.route) {
                        popUpTo(Route.Login.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = { navController.popBackStack() }
            )
        }
        composable(Route.Main.route) {
            MainScaffold(mainNavController = navController)
        }
        composable(Route.LessonDetail.route) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId")
            LessonDetailScreen(navController = navController, lessonId = lessonId)
        }
        composable(Route.Quiz.route) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId")
            QuizScreen(navController = navController, lessonId = lessonId)
        }
        composable(Route.Congratulations.route) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId")
            CongratulationsScreen(navController = navController, lessonId = lessonId)
        }
    }
}
