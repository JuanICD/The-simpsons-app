package com.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thesimpsomapp.R

@Preview(showBackground = true)
@Composable
fun ListManager() {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                onClick = {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
                }
            )
            {
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(R.drawable.homer),
                    contentDescription = "Homer image",
                )
            }
        }


    }
}