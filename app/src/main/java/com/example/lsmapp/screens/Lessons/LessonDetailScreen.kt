package com.example.lsmapp.screens.Lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lsmapp.data.model.Lesson
import com.example.lsmapp.screens.LogoContainerColor
import com.example.lsmapp.screens.PrimaryDarkGrey
import com.example.lsmapp.screens.TextLinkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(
    navController: NavController,
    lessonId: String?,
    viewModel: LessonDetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(lessonId) {
        lessonId?.let {
            viewModel.loadLesson(
                Lesson(
                    id = it,
                    title = "Lección $it: Saludos básicos",
                    topicId = "1",
                    videoUrl = "",
                    content = "Aprender a saludar es el primer paso para comunicarse en lengua de señas mexicana. Hoy vamos a aprender cómo decir:",
                    difficulty = "Medium",
                    expReward = 10,
                    bulletPoints = listOf("Hola", "Adiós", "¿Cómo estás?")
                )
            )
        }
    }

    Scaffold(
        containerColor = PrimaryDarkGrey,
        topBar = {
            TopAppBar(
                title = { Text(uiState.lesson?.title ?: "", color = TextLinkColor) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryDarkGrey)
            )
        }
    ) { innerPadding ->
        uiState.lesson?.let { lesson ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = LogoContainerColor)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray) // Placeholder color
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = lesson.difficulty,
                                color = MaterialTheme.colorScheme.tertiary,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(8.dp))
                                    .background(Color.White)
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                            Text(
                                text = "${lesson.expReward} xp",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.Black.copy(alpha = 0.5f))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = lesson.content, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                lesson.bulletPoints.forEach { point ->
                    Text(
                        text = "• $point",
                        color = TextLinkColor,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { navController.navigate("quiz/${lesson.id}") },
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(containerColor = LogoContainerColor)
                ) {
                    Text(text = "Empezar", color = TextLinkColor)
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, tint = TextLinkColor)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonDetailScreenPreview() {
    LessonDetailScreen(
        navController = NavController(LocalContext.current),
        lessonId = "1"
    )
}
