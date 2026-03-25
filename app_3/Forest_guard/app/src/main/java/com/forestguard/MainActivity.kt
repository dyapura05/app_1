package com.forestguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.forestguard.ui.navigation.NavGraph
import com.forestguard.ui.theme.ForestGuardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForestGuardTheme {
                NavGraph()
            }
        }
    }
}
