package com.patrickdev.notesboard.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patrickdev.notesboard.data.database.dao.NoteDao
import com.patrickdev.notesboard.data.database.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesBoardDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private const val NOTESBOARD_DATABASE_NAME = "notes_board"

        @Volatile
        private var Instance: NotesBoardDatabase? = null

        fun getDatabase(context: Context): NotesBoardDatabase {
            return Instance ?: synchronized(this) {
                Room
                    .databaseBuilder(
                        context,
                        NotesBoardDatabase::class.java,
                        NOTESBOARD_DATABASE_NAME
                    )
                    .createFromAsset("database/notes_board_database.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}