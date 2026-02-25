package com.maestro.tharwat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.runtime.CompositionLocalProvider

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Rtl
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudioScreen()
                }
            }
        }
    }
}

@Composable
fun StudioScreen() {

    var text by remember { mutableStateOf("أدخل طلب الإيقاع هنا") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "المايسترو ثروت",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("طلب الإيقاع") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* سنضيف توليد MIDI لاحقاً */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("توليد الإيقاع")
        }
    }
}
