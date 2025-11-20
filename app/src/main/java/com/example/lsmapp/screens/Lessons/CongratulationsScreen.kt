package com.example.lsmapp.screens.Lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lsmapp.R
import com.example.lsmapp.screens.LogoContainerColor
import com.example.lsmapp.screens.PrimaryDarkGrey
import com.example.lsmapp.screens.TextLinkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CongratulationsScreen(navController: NavController, lessonId: String?) {
    Scaffold(
        containerColor = PrimaryDarkGrey,
        topBar = {
            TopAppBar(
                title = { Text("¡Felicidades!", color = TextLinkColor) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryDarkGrey)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "¡Felicidades por terminar la lección!", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Experiencia adquirida", color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "5 exp", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("lesson") },
                colors = ButtonDefaults.buttonColors(containerColor = LogoContainerColor)
            ) {
                Text(text = "Volver a las lecciones", color = TextLinkColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CongratulationsScreenPreview() {
    CongratulationsScreen(
        navController = NavController(LocalContext.current),
        lessonId = "1"
    )
}
