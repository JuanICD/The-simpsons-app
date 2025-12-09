package com.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.thesimpsomapp.R

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
