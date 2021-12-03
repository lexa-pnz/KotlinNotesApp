package com.example.notesapp.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.module.AppNote

@Dao
interface AppRoomDao {

    @Query("SELECT * from notes_tables")
    fun getAllNotes():LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: AppNote)

    @Delete
    fun delete(note: AppNote)

    @Update
    fun update(note: AppNote)
}