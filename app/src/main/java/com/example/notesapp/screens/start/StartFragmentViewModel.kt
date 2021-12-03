package com.example.notesapp.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notesapp.database.firebase.AppFirebaseRepository
import com.example.notesapp.database.room.AppRoomDatabase
import com.example.notesapp.database.room.AppRoomRepository
import com.example.notesapp.utilits.REPOSITORY
import com.example.notesapp.utilits.TYPE_FIREBASE
import com.example.notesapp.utilits.TYPE_ROOM
import com.example.notesapp.utilits.showToast

class StartFragmentViewModel(application: Application):AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String, onSuccess:()->Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()},{ showToast(it)})
            }
        }

    }
}