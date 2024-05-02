package com.patrickdev.notesboard

import android.app.Application
import com.patrickdev.notesboard.data.AppContainer
import com.patrickdev.notesboard.data.NotesBoardContainer

class NotesBoardApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = NotesBoardContainer(this)
    }
}