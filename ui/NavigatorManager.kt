package com.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf

data object CharacterList
data class CharacterDetail(val id: Int)

@Composable
fun NavegationController(){
    val navController = { mutableStateListOf<Any>(CharacterList) }
}