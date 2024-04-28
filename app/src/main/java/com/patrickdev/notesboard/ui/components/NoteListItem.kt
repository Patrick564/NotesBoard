package com.patrickdev.notesboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NoteListItem() {
    Card(
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Title", fontSize = 12.sp)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "31/08/2024", fontSize = 10.sp)

                Icon(
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Add to favorite"
                )
            }
        }

        Text(
            modifier = Modifier.fillMaxWidth().padding(5.dp, 5.dp),
            text = "Example text",
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun IsFavorite() {
    Icon(
        modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
        imageVector = Icons.Filled.Favorite,
        contentDescription = "Add to favorite"
    )
}

@Composable
fun IsNotFavorite() {
    Icon(
        modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
        imageVector = Icons.Outlined.FavoriteBorder,
        contentDescription = "Add to favorite"
    )
}