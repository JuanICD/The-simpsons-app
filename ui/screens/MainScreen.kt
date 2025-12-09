package com.ui.screens

import android.graphics.fonts.Font
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyMainScreen(
    onListClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Welcome to the simpsons list",
            fontSize = 20.sp
        )


        Button(
            onClick = { onListClick() },
            modifier = Modifier.size(width = 120.dp, height = 50.dp)
        ) {
            Text(text = "List")
        }
        Button(
            onClick = { onAboutClick() },
            modifier = Modifier.size(width = 120.dp, height = 50.dp)
        ) {
            Text(text = "About")
        }
    }
}