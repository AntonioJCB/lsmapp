package com.example.lsmapp.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lsmapp.components.BottomNavBar
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(onLogoutClick: () -> Unit, onNavigateToAuth: () -> Unit) {
    val nav = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Navegación", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp))
                DrawerItem(nav, label = "Lecciones", dest = Route.Lesson.route, drawerState, scope)
                DrawerItem(nav, label = "Señas", dest = Route.Senas.route, drawerState, scope)
                DrawerItem(nav, label = "Ranking", dest = Route.Ranking.route, drawerState, scope)
                DrawerItem(nav, label = "Configuración", dest = Route.Settings.route, drawerState, scope)
                Divider()
                NavigationDrawerItem(
                    label = { Text("Cerrar sesión") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        onLogoutClick()
                        onNavigateToAuth()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Template App") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = nav,
                    startDestination = Route.Lesson.route,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(Route.Lesson.route) { LessonScreen(navController = nav) }
                    composable(Route.Senas.route) { SenasScreen() }
                    composable(Route.Ranking.route) { RankingScreen() }
                    composable(Route.Settings.route) { SettingsScreen() }
                }
                BottomNavBar(
                    navController = nav,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}

@Composable
private fun DrawerItem(
    nav: NavHostController,
    label: String,
    dest: String,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    NavigationDrawerItem(
        label = { Text(label) },
        selected = currentRoute(nav) == dest,
        onClick = {
            nav.navigate(dest) { launchSingleTop = true }
            scope.launch { drawerState.close() }
        }
    )
}

@Composable
private fun currentRoute(nav: NavHostController): String? {
    val backStackEntry by nav.currentBackStackEntryAsState()
    return backStackEntry?.destination?.route
}
