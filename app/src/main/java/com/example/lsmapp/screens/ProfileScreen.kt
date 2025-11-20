package com.example.lsmapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ProfileScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(PrimaryDarkGrey),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Pantalla de Perfil",
            color = Color.White
        )
    }
}
