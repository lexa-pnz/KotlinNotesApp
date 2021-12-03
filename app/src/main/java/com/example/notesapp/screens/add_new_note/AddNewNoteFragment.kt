package com.example.notesapp.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentAddNewNoteBinding
import com.example.notesapp.module.AppNote
import com.example.notesapp.utilits.APP_ACTIVITY
import com.example.notesapp.utilits.showToast


class AddNewNoteFragment : Fragment() {

    private var _binding:FragmentAddNewNoteBinding ?= null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener {
            val nameNote = mBinding.inputNameNote.text.toString()
            val textNote = mBinding.inputTextNote.text.toString()
            if (nameNote.isEmpty() and textNote.isEmpty()){
                showToast(getString(R.string.toast_enter_name_or_text))
            } else {
                mViewModel.insert(AppNote(name = nameNote, text = textNote)){
                    APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}