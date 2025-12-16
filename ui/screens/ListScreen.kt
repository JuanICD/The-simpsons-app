package com.example.myapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapp.data.CharacterRepository.characterList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCardList(
    onBack: () -> Unit,
    navigateToDetail: (Int) -> Unit
) {

    Scaffold(
        topBar = {
            //Dfinir la TopAppBar
            TopAppBar(
                title = { Text(text = "Characters") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver atrás"
                        )
                    }
                }
            )

        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            items(characterList) { character ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    onClick = { navigateToDetail(character.id) },
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
                )
                {
                    Row() {

                        Image(
                            modifier = Modifier.padding(10.dp),
                            painter = painterResource(character.image),
                            contentDescription = character.description.toString(),
                        )
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = stringResource(id = character.description),
                            maxLines = 3,
                            textAlign = TextAlign.Start,
                        )
                    }

                }
            }


        }
    }


}

