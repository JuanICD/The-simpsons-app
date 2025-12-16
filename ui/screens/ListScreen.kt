package com.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

import com.ui.states.CharacterListState
import com.ui.viewmodels.CharacterListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCardList(
    onBack: () -> Unit,
    navigateToDetail: (Int) -> Unit
) {

    val viewModel: CharacterListViewModel = viewModel()
    val chacterListState by viewModel.characterListState.collectAsStateWithLifecycle()


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
                },

                )

        },
        containerColor = MaterialTheme.colorScheme.onBackground
    ) { innerPadding ->
        Box() {

            when (chacterListState) {

                is CharacterListState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is CharacterListState.Error -> {
                    Text(
                        text = "Error: ${(chacterListState as CharacterListState.Error).msg}",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }

                is CharacterListState.Empty -> {
                    Text(
                        text = "No hay personajes disponibles",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is CharacterListState.Success -> {
                    val characters = (chacterListState as CharacterListState.Success).characters

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {

                        items(characters) { character ->

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                onClick = { navigateToDetail(character.id) },
                                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
                            )
                            {
                                Row() {

                                    AsyncImage(
                                        modifier = Modifier.padding(10.dp),
                                        model = character.portrait_path,
                                        contentDescription = character.name,
                                    )
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = character.name,
                                        maxLines = 3,
                                        textAlign = TextAlign.Start,
                                    )
                                }

                            }
                        }


                    }

                }
            }

        }


    }


}

@Preview
@Composable
fun ImageCardListPreview() {
    ImageCardList(onBack = {}, navigateToDetail = {})
}

