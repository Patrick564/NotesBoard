package com.patrickdev.notesboard.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.patrickdev.notesboard.NotesBoardApplication
import com.patrickdev.notesboard.ui.screens.home.HomeViewModel
import com.patrickdev.notesboard.ui.screens.note.NoteViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(notesBoardApplication().container.noteRepository)
        }

        initializer {
            NoteViewModel(notesBoardApplication().container.noteRepository)
        }

//        initializer {
////            this.createSavedStateHandle()
//        }
    }
}

fun CreationExtras.notesBoardApplication(): NotesBoardApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NotesBoardApplication)