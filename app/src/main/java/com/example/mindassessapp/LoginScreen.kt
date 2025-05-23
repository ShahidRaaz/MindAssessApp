package com.example.mindassessapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFFEFF2FF), shape = RoundedCornerShape(size = 30.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.height(500.dp)
        ) {
            // Child views.
            Image(
                painter = painterResource(id = R.drawable.logoimg),
                contentDescription = "image description",
                modifier = Modifier.height(90.dp).width(90.dp)
            )
            Text(
                text = "Mind Assess",
                color = Color(0xFF00137F),
                fontSize = 32.sp,
                fontWeight = FontWeight(400),
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(393.dp).height(345.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 30.dp))
                .padding(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
        ) {
            // Child views.
            Text(
                text = "Login Here",
                fontSize = 24.sp,
//                fontFamily = FontFamily(Font(R.font.outfit)),
                fontWeight = FontWeight(400),
                color = Color(0xFF444444),
                textAlign = TextAlign.Center,
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.width(393.dp)
            ) {
                // Child views.
                Text(
                    text = "Enter Email ID",
                    fontSize = 16.sp,
//                        fontFamily = FontFamily(Font(R.font.outfit)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF444444),
                    textAlign = TextAlign.Center,
                )
                Row(
                    modifier = Modifier.fillMaxWidth().height(42.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFF444444),
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    var email by remember { mutableStateOf("") }

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text(
                                text = "Your ID",
                                color = Color.Gray // Make sure it's visible
                            )
                        },
                        singleLine = true,
                        modifier = Modifier
                            .width(220.dp)
                            .height(52.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Black,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Gray
                        )
                    )

                    Text(
                        text = "@gmail.com",
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Right,
                        modifier = Modifier
                            .width(150.dp)
                            .height(24.dp)
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.width(393.dp)
            ) {
                // Password Field with "Forgot Password?"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Enter Password",
                        fontSize = 16.sp,
//                        fontFamily = FontFamily(Font(R.font.outfit)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF444444),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Forgot Password?",
                        color = Color(0xFF0026A3),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { /* Handle forgot */ }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth().height(42.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFF444444),
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text(
                                text = "XXX XXX XX",
                                color = Color.Gray // Make sure it's visible
                            )
                        },
                        singleLine = true,
                        modifier = Modifier
                            .width(220.dp)
                            .height(52.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )

                    var password by remember { mutableStateOf("") }
                    var passwordVisible by remember { mutableStateOf(false) }

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("Password", color = Color.Gray) },
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                val iconRes = if (passwordVisible) R.drawable.ptv else R.drawable.ptnv
                                Icon(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                    tint = Color.Gray
                                )
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        modifier = Modifier
                            .width(250.dp)
                            .height(56.dp)
                    )


                }
            }
            Button(
                onClick = { /* Handle Login */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0026A3)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Login", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
        LoginScreen()
}