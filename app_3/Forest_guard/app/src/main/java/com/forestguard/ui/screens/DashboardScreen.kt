package com.forestguard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.forestguard.ui.components.FloatingChatbot
import com.forestguard.ui.components.RiskGauge
import com.forestguard.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Panel de Control", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Text("☰", fontSize = 24.sp, color = TextWhite)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Notifications, contentDescription = "Alertas", tint = AccentRedAlert)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkGreenBackground)
            )
        },
        containerColor = DarkGreenBackground
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nivel de Riesgo Hoy",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            RiskGauge(modifier = Modifier.padding(vertical = 24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherInfoCard(label = "Vientos", value = "45km/h")
                WeatherInfoCard(label = "Humedad", value = "12%")
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* Navigate to report */ },
                colors = ButtonDefaults.buttonColors(containerColor = RiskHigh),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("🔥 Reportar Avistamiento", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
        
        FloatingChatbot()
    }
}

@Composable
fun WeatherInfoCard(label: String, value: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DeepGreenContainer),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, color = TextGrey, fontSize = 12.sp)
            Text(text = value, color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
