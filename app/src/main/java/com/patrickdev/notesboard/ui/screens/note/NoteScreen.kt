package com.patrickdev.notesboard.ui.screens.note

import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.patrickdev.notesboard.data.database.entities.NoteEntity
import com.patrickdev.notesboard.ui.AppViewModelProvider
import com.patrickdev.notesboard.ui.components.NoteTopAppBar
import com.patrickdev.notesboard.ui.screens.home.HomeViewModel
import com.patrickdev.notesboard.ui.screens.home.PreviewHomeViewModel
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@Preview
@Composable
fun PreviewNoteScreen() {
    val previewNavController = rememberNavController()

    NoteScreen(previewNavController, PreviewNoteViewModel())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    navController: NavController,
    noteViewModel: NoteViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()

    var note by remember { mutableStateOf(NoteDetails()) }

    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ), title = {}, navigationIcon = {
            IconButton(onClick = { scope.launch { navController.popBackStack() } }) {
                Icon(
                    imageVector = Icons.Filled.Clear, contentDescription = "Close button"
                )
            }
        }, actions = {
            IconButton(onClick = {
                scope.launch { noteViewModel.addNote(note) }
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.Check, contentDescription = "Save button"
                )
            }
        }, scrollBehavior = scrollBehavior
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(text = "Hellooooooooo", modifier = Modifier.padding(paddingValues))

            TextField(
                value = note.content,
                onValueChange = { note = note.copy(content = it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(350.dp)
            )
        }
    }
}