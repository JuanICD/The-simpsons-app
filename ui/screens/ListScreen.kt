package com.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.data.CharacterRepository.characterList

@Composable
fun ImageCardList(
    navigateToDetail: (Int) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(20) {
            val randomCharacter = characterList.random()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = { navigateToDetail(randomCharacter.id) }
            )
            {
                Row() {

                    Image(
                        modifier = Modifier.padding(10.dp),
                        painter = painterResource(randomCharacter.image),
                        contentDescription = randomCharacter.description.toString(),
                    )
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = stringResource(id = randomCharacter.description),
                        maxLines = 3,
                        textAlign = TextAlign.Start,
                    )
                }

            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun ImageCardListPreview() {
    ImageCardList(navigateToDetail = {})

}