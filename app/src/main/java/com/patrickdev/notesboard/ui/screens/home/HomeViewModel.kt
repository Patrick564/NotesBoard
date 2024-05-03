package com.patrickdev.notesboard.ui.screens.home

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import com.patrickdev.notesboard.data.INoteRepository
import com.patrickdev.notesboard.data.PreviewNoteRepository
import com.patrickdev.notesboard.data.database.entities.NoteEntity
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class HomeViewModel(private val noteRepository: INoteRepository) : ViewModel() {
    open val allNotes: LiveData<List<NoteEntity>> = noteRepository.allNotes

    open fun addNote(note: NoteEntity) = viewModelScope.launch { noteRepository.addNote(note) }
}

class PreviewHomeViewModel() : HomeViewModel(PreviewNoteRepository()) {
    override val allNotes: LiveData<List<NoteEntity>> = MutableLiveData()

    override fun addNote(note: NoteEntity) = Job()
}