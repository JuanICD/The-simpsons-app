package com.navegation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.data.datasources.CharacterApiService
import com.data.CharacterRepository
import com.data.datasources.CharacterRemoteDataSource
import com.data.models.Character
import com.example.myapp.ui.screens.AboutScreen
import com.ui.screens.CharacterDetailScreen
import com.ui.screens.ImageCardList
import com.ui.screens.MyMainScreen

data object List
data object About
data object Home
data class CharacterDetail(val id: Int)

@Composable
fun NavigationController() {
    val backStack = remember { mutableStateListOf<Any>(Home) }
    val coroutineScope = rememberCoroutineScope()
    val apiService = remember { CharacterApiService }
    val remoteDataSource = remember { CharacterRemoteDataSource() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    MyMainScreen(
                        onListClick = { backStack.add(List) },
                        onAboutClick = { backStack.add(About) }
                    )
                }

                is List -> NavEntry(key) {
                    ImageCardList(
                        // Parámetro 1: La acción para el botón de "atrás"
                        onBack = { backStack.removeLastOrNull() },

                        // Parámetro 2: La acción para cuando se hace clic en una tarjeta
                        navigateToDetail = { characterId ->
                            backStack.add(CharacterDetail(id = characterId))
                        }
                    )
                }

                is CharacterDetail -> NavEntry(key) {
                    val character = CharacterRepository.getCharacterById(key.id, emptyList())
                    if (character != null) {
                        CharacterDetailScreen(character = it)
                    } else {
                        Text(text = "Error: Character not found")
                    }
                }


                is About -> NavEntry(key) {
                    AboutScreen(onBack = { backStack.removeLastOrNull() })
                }


                else -> NavEntry(key) {
                    Text("Error")
                }
            }
        }
    )

}