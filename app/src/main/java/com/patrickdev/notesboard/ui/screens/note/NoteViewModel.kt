package com.patrickdev.notesboard.ui.screens.note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patrickdev.notesboard.data.INoteRepository
import com.patrickdev.notesboard.data.PreviewNoteRepository
import com.patrickdev.notesboard.data.database.entities.NoteEntity
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

data class NoteDetails(
    val id: Int = 0,
    val title: String = "",
    val date: String = "",
    val content: String = "",
    val categories: String = "",
    val background: String = "",
    val isReadOnly: Int = 0,
    val isFavorite: Int = 0
)

fun NoteDetails.toNoteEntity(): NoteEntity = NoteEntity(
    id = id,
    title = title,
    date = date,
    content = content,
    categories = categories,
    background = background,
    isReadOnly = isReadOnly,
    isFavorite = isFavorite
)

open class NoteViewModel(private val noteRepository: INoteRepository) : ViewModel() {
    // var note by mutableStateOf(NoteDetails())

//    fun updateNoteState(noteDetails: NoteDetails) {
//        note = noteDetails
//    }

    open suspend fun addNote(note: NoteDetails) =  noteRepository.addNote(note.toNoteEntity())
}

class  PreviewNoteViewModel: NoteViewModel(PreviewNoteRepository()) {
    override suspend fun addNote(note: NoteDetails) {}
}