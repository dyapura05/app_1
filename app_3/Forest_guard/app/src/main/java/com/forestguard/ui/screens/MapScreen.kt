package com.forestguard.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.forestguard.ui.theme.AccentRedAlert
import com.forestguard.ui.theme.DarkGreenBackground
import com.forestguard.ui.theme.TextWhite

@Composable
fun MapScreen() {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
        // Map Placeholder
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Mapa ForestGuard", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        // Search Bar Placeholder
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = CircleShape
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Text("🔍 Buscar zona o coordenadas...", color = Color.Gray)
            }
        }

        // EMERGENCY BUTTON (911) - CENTERED AND DYNAMIC
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LargeSOSButton(onClick = {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))
                context.startActivity(intent)
            })
        }

        // Bottom Info Sheet Placeholder
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("TU UBICACIÓN", fontSize = 12.sp, color = Color.Gray)
                Text("Reserva Nacional Peñuelas", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun LargeSOSButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(120.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = AccentRedAlert),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 12.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Phone, contentDescription = "SOS", modifier = Modifier.size(32.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text("911", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
            Text("SOS", fontSize = 12.sp)
        }
    }
}
