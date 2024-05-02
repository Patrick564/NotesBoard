package com.patrickdev.notesboard.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patrickdev.notesboard.data.INoteRepository
import com.patrickdev.notesboard.data.database.entities.NoteEntity
import kotlinx.coroutines.launch

class HomeViewModel(private val noteRepository: INoteRepository) : ViewModel() {
    val allNotes: LiveData<List<NoteEntity>> = noteRepository.allNotes

    fun addNote(note: NoteEntity) = viewModelScope.launch { noteRepository.addNote(note) }
}