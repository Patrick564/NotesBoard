package com.patrickdev.notesboard.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "categories") val categories: String?,
    @ColumnInfo(name = "background") val background: String,
    @ColumnInfo(name = "is_read_only") val isReadOnly: Int,
    @ColumnInfo(name = "is_favorite") val isFavorite: Int
)