package com.example.notesapp.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notesapp.utilits.REPOSITORY

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes

    fun signOut(){
        REPOSITORY.signOut()
    }
}