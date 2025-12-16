package com.example.myapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myapp.R


data class Character(
    val id: Int,
    val name: String,
    val age: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

object CharacterRepository {
    val characterList =
        listOf<Character>(
            Character
                (
                1,
                "Homer",
                35,
                R.string.homer_description,
                R.drawable.homer
            ),
            Character(
                2,
                "Marge",
                36,
                R.string.marge_description,
                R.drawable.marge
            ),
            Character(
                3,
                "Bart",
                12,
                R.string.bart_description,
                R.drawable.bart
            ),
            Character(
                4,
                "Lisa",
                8,
                R.string.lisa_description,
                R.drawable.lisa // Necesitarás una imagen lisa.png
            ),
            Character(
                5,
                "Maggie",
                1,
                R.string.maggie_description,
                R.drawable.maggie // Necesitarás una imagen maggie.png
            ),
            Character(
                6,
                "Mr. Burns",
                104,
                R.string.burns_description,
                R.drawable.burns // Necesitarás una imagen burns.png
            ),
            Character(
                7,
                "Krusty",
                52,
                R.string.krusty_description,
                R.drawable.krusty // Necesitarás una imagen krusty.png
            ),
            Character(
                8,
                "Moe",
                47,
                R.string.moe_description,
                R.drawable.moe // Necesitarás una imagen moe.png
            )


        )

    //Funcion que devuelva la cas por id, si no existe devuelve null
    fun getCharacterById(id: Int): Character? {
        return characterList.find { it.id == id }
    }

    //Funcion que devuelva la cas por id, si no existe devuelve null( FORMA CLASICA )
    fun getCharacterById2(id: Int): Character? {
        for (character in characterList) {
            if (character.id == id) {
                return character
            }
        }
        return null
    }


}
