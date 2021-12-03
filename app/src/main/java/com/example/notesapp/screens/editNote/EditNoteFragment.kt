package com.example.notesapp.screens.editNote

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentEditingNoteBinding
import com.example.notesapp.databinding.FragmentNoteBinding
import com.example.notesapp.module.AppNote
import com.example.notesapp.screens.note.NoteFragmentViewModel
import com.example.notesapp.utilits.APP_ACTIVITY
import com.example.notesapp.utilits.showToast

class EditNoteFragment : Fragment(){
    private var _binding: FragmentEditingNoteBinding?= null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: EditFragmentViewModel
    private lateinit var mCurrentNote:AppNote

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentEditingNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mBinding.noteNameEdit.setText(mCurrentNote.name)
        mBinding.noteTextEdit.setText(mCurrentNote.text)

        mViewModel = ViewModelProvider(this).get(EditFragmentViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_save -> {
                showToast("Изменения сохранены")
                mViewModel.update(mCurrentNote) {
                    APP_ACTIVITY.navController.navigate(R.id.action_fragment_editing_note_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}