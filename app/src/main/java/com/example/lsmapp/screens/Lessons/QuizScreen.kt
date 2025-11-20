package com.example.lsmapp.screens.Lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lsmapp.screens.PrimaryDarkGrey
import com.example.lsmapp.screens.TextLinkColor
import com.example.lsmapp.ui.theme.LsmappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    navController: NavController,
    lessonId: String?,
    viewModel: QuizViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        containerColor = PrimaryDarkGrey,
        topBar = {
            TopAppBar(
                title = { Text("Quiz", color = TextLinkColor) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryDarkGrey)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "Pregunta 1", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = uiState.question, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            uiState.options.forEach { option ->
                Button(
                    onClick = { navController.navigate("congratulations/$lessonId") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(text = option, color = Color.Black)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    LsmappTheme {
        QuizScreen(
            navController = NavController(LocalContext.current),
            lessonId = "1"
        )
    }
}
