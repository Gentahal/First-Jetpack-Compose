package com.example.firstjetpackcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstjetpackcompose.R

@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF1976D2), Color(0xFF42A5F5))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically // Pastikan library mendukung properti ini
            ) {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Your Profile",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
            }


            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.head_1), // Ganti dengan gambar profil
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // User Name
            Text(
                text = "Genta Halilintar",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // User Info
            Text(
                text = "gentaworks@gmail.com",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White.copy(alpha = 0.8f)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Info Section
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    ProfileInfoRow(label = "Phone", value = "+1 234 567 890")
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    ProfileInfoRow(label = "Address", value = "123 Main St, Springfield")
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    ProfileInfoRow(label = "Membership", value = "Premium Member")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Logout Button
            Button(
                onClick = { /* Logout action */ },
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Logout")
            }
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
