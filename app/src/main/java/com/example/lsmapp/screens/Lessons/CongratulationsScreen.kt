package com.example.lsmapp.screens.Lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lsmapp.R
import com.example.lsmapp.navigation.Route
import com.example.lsmapp.screens.PrimaryDarkGrey
import com.example.lsmapp.ui.theme.LsmappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CongratulationsScreen(navController: NavController, lessonId: String?) {

    Scaffold(
        containerColor = PrimaryDarkGrey,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "¡Felicidades!",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryDarkGrey)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navController.popBackStack(Route.Main.route, inclusive = false)
                }
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¡Felicidades por terminar la lección!",
                color = Color.White,
                fontSize = 22.sp // Letra más grande
            )
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.smilignhamster), // Imagen del hámster
                contentDescription = "Hámster sonriente",
                modifier = Modifier.size(180.dp) // Tamaño ajustado
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Experiencia adquirida",
                color = Color.White,
                fontSize = 20.sp // Letra más grande
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "5 exp",
                color = Color.White,
                fontSize = 18.sp, // Letra más grande
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CongratulationsScreenPreview() {
    LsmappTheme {
        CongratulationsScreen(
            navController = NavController(LocalContext.current),
            lessonId = "1"
        )
    }
}
