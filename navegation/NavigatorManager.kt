package com.navegation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.myapp.data.CharacterRepository
import com.example.myapp.ui.screens.AboutScreen
import com.ui.screens.CharacterDetailScreen
import com.example.myapp.ui.screens.ImageCardList
import com.ui.screens.MyMainScreen

data object List
data object About
data object Home
data class CharacterDetail(val id: Int)

@Composable
fun NavigationController() {
    val backStack = remember { mutableStateListOf<Any>(Home) }

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
                    val character = CharacterRepository.getCharacterById(key.id)
                    if (character != null) {
                        CharacterDetailScreen(character = character)
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