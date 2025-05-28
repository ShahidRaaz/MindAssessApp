package com.example.mindassessapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}


@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FE))
            .padding(20.dp)
    ) {
        // Logo and App Name
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

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Welcome, Shaaz", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Available Assessments", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        AssessmentCard(
            title = "Personality Test",
            participants = "25 Participated",
            description = "Understand your personality traits and how you behave."
        )
        Spacer(modifier = Modifier.height(16.dp))
        AssessmentCard(
            title = "Aptitude Test",
            participants = "25 Participated",
            description = "Assess your logical reasoning, problem-solving, and numerical ability."
        )
        Spacer(modifier = Modifier.height(16.dp))
        AssessmentCard(
            title = "Emotional Intelligence Test",
            participants = "25 Participated",
            description = "Evaluate your ability to recognize, understand, and manage emotions."
        )
    }
}

@Composable
fun AssessmentCard(title: String, participants: String, description: String) {
    Card(
        modifier = Modifier.fillMaxWidth().border(1.dp, color = Color(0xFF00137F),RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = participants, fontSize = 14.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.timg), // Add your timer icon
                    contentDescription = "Time",
                    tint = Color.Black,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "10 minutes", fontSize = 14.sp)

                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    painter = painterResource(id = R.drawable.qimg), // Add your question icon
                    contentDescription = "Questions",
                    tint = Color.Black,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "20 Questions", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            val context = LocalContext.current
            Button(
                onClick = { val intent = Intent(context, TestActivity::class.java)
                    context.startActivity(intent) },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00137F)),
                modifier = Modifier.fillMaxWidth().height(44.dp)
            ) {
                Text("Start Assessment", color = Color.White)
            }
        }
    }
}


