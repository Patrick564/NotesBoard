package com.patrickdev.notesboard.ui.screens.note

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.patrickdev.notesboard.ui.components.NoteTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            NoteTopAppBar(navController, scope, scrollBehavior)
        }
    ) { innerPadding ->
        Text(text = "Hellooooooooo", modifier = Modifier.padding(innerPadding))
    }
}