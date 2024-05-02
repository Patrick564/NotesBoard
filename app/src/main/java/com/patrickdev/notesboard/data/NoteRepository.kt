package com.patrickdev.notesboard.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.patrickdev.notesboard.data.database.dao.NoteDao
import com.patrickdev.notesboard.data.database.entities.NoteEntity

interface INoteRepository {
    val allNotes: LiveData<List<NoteEntity>>

    suspend fun addNote(note: NoteEntity)
}

class NoteRepository(private val noteDao: NoteDao) : INoteRepository {

    override val allNotes: LiveData<List<NoteEntity>> = noteDao.getAll().asLiveData()

    override suspend fun addNote(note: NoteEntity) {
        noteDao.add(note)
    }
}

class PreviewNoteRepository : INoteRepository {
    override val allNotes: LiveData<List<NoteEntity>> = MutableLiveData()

    override suspend fun addNote(note: NoteEntity) { }
}