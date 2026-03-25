package com.forestguard.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.forestguard.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen() {
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGreenBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Reportar Riesgo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextWhite,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Camera Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Black, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("Vista de Cámara", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Ubicación Detectada",
            modifier = Modifier.fillMaxWidth(),
            color = TextGrey,
            fontSize = 14.sp
        )
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(containerColor = DeepGreenContainer)
        ) {
            Text(
                "📍 Sierra Norte, Sector Valparaiso",
                modifier = Modifier.padding(16.dp),
                color = TextWhite
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Descripción",
            modifier = Modifier.fillMaxWidth(),
            color = TextGrey,
            fontSize = 14.sp
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            placeholder = { Text("¿Qué ves? (Humo, fuego, cables caídos...)") },
            modifier = Modifier.fillMaxWidth().height(120.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = TextWhite,
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = PrimaryNeonGreen
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* Send Report */ },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNeonGreen),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("ENVIAR REPORTE", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}
