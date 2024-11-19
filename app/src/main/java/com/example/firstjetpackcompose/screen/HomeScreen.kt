package com.example.firstjetpackcompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF1976D2), Color(0xFF42A5F5))
                )
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome!",
                style = MaterialTheme.typography.displaySmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Explore the app and enjoy the experience.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White.copy(alpha = 0.8f)
                ),
                modifier = Modifier.padding(horizontal = 24.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .width(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile Icon",
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp),
                        tint = Color(0xFF42A5F5)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { navController.navigate("profile") },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Go to Profile")
                    }
                }
            }
        }
    }
}
