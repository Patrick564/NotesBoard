package com.patrickdev.notesboard.data

import android.content.Context
import com.patrickdev.notesboard.data.database.NotesBoardDatabase

interface AppContainer {
    val noteRepository: NoteRepository
}

class NotesBoardContainer(private val context: Context) : AppContainer {
    override val noteRepository: NoteRepository by lazy {
        NoteRepository(NotesBoardDatabase.getDatabase(context).noteDao())
    }
}