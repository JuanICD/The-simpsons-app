package com.data


import com.data.models.Character
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int,
    val name: String,
    val age: Int,
    val portrait_path: Int
)

object CharacterRepository {

    //Funcion que devuelva la cas por id, si no existe devuelve null
    fun getCharacterById(id: Int, characterList: List<Character>): Character? {
        return characterList.find { it.id == id }
    }


}
