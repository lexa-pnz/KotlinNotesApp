package com.example.notesapp.database.room

import androidx.lifecycle.LiveData
import com.example.notesapp.database.DatabaseRepository
import com.example.notesapp.module.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }

    override suspend fun update(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.update(note)
        onSuccess()
    }

    override fun signOut() {
        super.signOut()
    }

}