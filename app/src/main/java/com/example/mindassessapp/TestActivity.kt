package com.example.mindassessapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestScreen()
        }
    }
}

@Composable
fun TestScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF5F7FE))
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
            ) {
                // You can replace this with your logo
                Icon(
                    painter = painterResource(id = R.drawable.logoimg), // Replace with your image resource
                    tint = Color(0xFF001A72),
                    contentDescription = "Mind Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Mind Assess",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF001A72),
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Personality Assessment",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Text(
                text = "Understand your personality traits and how you behave.",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Timer
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.timg),
                    contentDescription = "Timer",
                    tint = Color(0xFF001A72),
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))
                var timeInSeconds by remember { mutableStateOf(0) }

                LaunchedEffect(Unit) {
                    while (timeInSeconds < 600) { // 600 seconds = 10 minutes
                        delay(1000L) // wait for 1 second
                        timeInSeconds++
                    }
                }

                val minutes = timeInSeconds / 60
                val seconds = timeInSeconds % 60

                val formattedTime = String.format("%02d:%02d", minutes, seconds)

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = formattedTime,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "/10:00",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        val questions = listOf(
            "Understand your personality traits and how you behave.",
            "How do you handle stress in daily life?",
            "What motivates you to succeed?"
        ) + List(17) { "Question ${it + 4} goes here." }

        val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        var currentIndex by remember { mutableStateOf(0) }
        val selectedAnswers =
            remember { mutableStateListOf<Int?>().apply { repeat(questions.size) { add(null) } } }

        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Question Counter
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.qimg),
                    contentDescription = "Question",
                    tint = Color(0xFF001A72),
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Question ${currentIndex + 1}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "/20",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Card(
                modifier = Modifier.fillMaxWidth()
                    .border(1.dp, color = Color(0xFF00137F), RoundedCornerShape(10.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Column(
                    modifier = Modifier.wrapContentSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Question Text
                    Text(
                        text = questions[currentIndex],
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Options List
                    options.forEachIndexed { index, option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedAnswers[currentIndex] = index
                                }
                                .padding(vertical = 6.dp)
                        ) {
                            RadioButton(
                                selected = selectedAnswers[currentIndex] == index,
                                onClick = {
                                    selectedAnswers[currentIndex] = index
                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFF00137F),
                                    unselectedColor = Color(0xFFD6D6F3)
                                )
                            )
                            Text(
                                text = option,
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = if (selectedAnswers[currentIndex] == index) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(36.dp))

        // Navigation Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Previous Button
            Button(
                onClick = { if (currentIndex > 0) currentIndex-- },
                enabled = currentIndex > 0,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF00137F),
                ),
                border = BorderStroke(1.dp, Color(0xFF00137F)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Previous")
            }

            // Next or Submit Button
            val context = LocalContext.current
            Button(
                onClick = {
                    if (currentIndex < questions.size - 1) {
                        currentIndex++
                    } else {
                        // Submit action here
                        // Example: show result screen or toast
                        val intent = Intent(context, TSubmitActivity::class.java)
                        context.startActivity(intent)
                        println("Submitted!")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00137F),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(if (currentIndex == questions.size - 1) "Submit" else "Next")
            }
        }
    }
}
