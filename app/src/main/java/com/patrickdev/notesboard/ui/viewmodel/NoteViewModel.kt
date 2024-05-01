package com.patrickdev.notesboard.ui.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patrickdev.notesboard.data.NoteRepository
import com.patrickdev.notesboard.data.database.NotesBoardDatabase
import com.patrickdev.notesboard.data.database.entities.NoteEntity
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class INoteViewModel : ViewModel() {
    abstract val allNotes: LiveData<List<NoteEntity>>

    abstract fun addNote(note: NoteEntity): Job
}

class NoteViewModel(private val noteRepository: NoteRepository) : INoteViewModel() {
    override val allNotes: LiveData<List<NoteEntity>> = noteRepository.allNotes

    override fun addNote(note: NoteEntity) = viewModelScope.launch { noteRepository.addNote(note) }
}

class PreviewNoteViewModel() : INoteViewModel() {
    override val allNotes: LiveData<List<NoteEntity>> = MutableLiveData()

    override fun addNote(note: NoteEntity): Job = Job()
}