package com.patrickdev.notesboard.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.patrickdev.notesboard.NotesBoardApplication
import com.patrickdev.notesboard.ui.screens.home.HomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(notesBoardApplication().container.noteRepository)
        }
    }
}

fun CreationExtras.notesBoardApplication(): NotesBoardApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NotesBoardApplication)