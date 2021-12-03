package com.example.notesapp.screens.editNote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.module.AppNote
import com.example.notesapp.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditFragmentViewModel(application: Application): AndroidViewModel(application) {
//    fun update(note: AppNote, onSuccess:()->Unit) =
//        viewModelScope.launch(Dispatchers.IO){
//            REPOSITORY.update(note){
//                onSuccess()
//            }
//        }

    fun update(note: AppNote, onSuccess:()->Unit) =
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(note){
                onSuccess()
            }

//            REPOSITORY.insert(note){
//                onSuccess()
//            }
        }
}