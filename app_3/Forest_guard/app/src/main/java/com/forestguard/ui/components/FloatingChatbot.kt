package com.forestguard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.forestguard.ui.theme.PrimaryNeonGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingChatbot() {
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { showSheet = true },
            containerColor = PrimaryNeonGreen,
            contentColor = Color.Black
        ) {
            Icon(Icons.Default.Chat, contentDescription = "Chat con IA")
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            ChatInterface(
                onClose = { showSheet = false }
            )
        }
    }
}

@Composable
fun ChatInterface(onClose: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(400.dp)
    ) {
        Text(
            "Asistente ForestGuard",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // Placeholder for chat messages
        Box(modifier = Modifier.weight(1f)) {
            Text("¡Hola! Soy tu asistente. Puedo ayudarte con sugerencias sobre prevención de incendios y uso de la app.")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Escribe tu consulta...") },
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = { /* Send message logic */ },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Enviar")
            }
        }
    }
}
