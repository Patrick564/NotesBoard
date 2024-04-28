package com.patrickdev.notesboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterTags() {
    val tags = listOf("Todos", "Tareas", "Comida", "Compras", "Trabajo", "Ideas")

    var lastSelected = "Todos"
    val selectedGroup = remember {
        mutableStateMapOf<String, Boolean>().apply {
            tags.forEach {
                put(it, false)
            }
        }
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(end = 16.dp)
    ) {
        items(tags) { tag ->
            FilterChip(
                selected = selectedGroup[tag] ?: false,
                onClick = {
                    selectedGroup[lastSelected] = false
                    selectedGroup[tag] = true

                    lastSelected = tag
                },
                label = { Text(text = tag) },
                leadingIcon = if (selectedGroup[tag] == true) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Selected tag",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                }
            )
        }
    }
}