package com.patrickdev.notesboard.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.patrickdev.notesboard.data.database.dao.NoteDao
import com.patrickdev.notesboard.data.database.entities.NoteEntity

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<NoteEntity>> = noteDao.getAll().asLiveData()

    suspend fun addNote(note: NoteEntity) {
        noteDao.add(note)
    }
}