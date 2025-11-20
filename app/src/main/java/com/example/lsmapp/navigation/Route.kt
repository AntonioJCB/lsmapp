package com.example.lsmapp.navigation

sealed class Route(val route: String) {
    data object Splash : Route("splash")
    data object Auth : Route("auth")
    data object Main : Route("main")

    // Auth internas
    data object Login : Route("login")
    data object Register : Route("register")

    // Main internas
    data object Lesson : Route("lesson")
    data object LessonDetail : Route("lessonDetail/{lessonId}")
    data object Quiz : Route("quiz/{lessonId}")
    data object Congratulations : Route("congratulations/{lessonId}")
    data object Profile : Route("profile")
    data object Settings : Route("settings")
    data object Senas : Route("senas")
    data object Ranking : Route("ranking")
}
