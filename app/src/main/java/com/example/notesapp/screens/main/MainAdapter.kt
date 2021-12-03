package com.example.notesapp.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.module.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    companion object {
        @JvmStatic lateinit var myNote: AppNote
    }

    class MainHolder(view: View):RecyclerView.ViewHolder(view){
        val nameNote:TextView = view.item_note_name
        val textNote:TextView = view.note_text
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener{
            myNote = mListNotes[holder.adapterPosition]
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes[position].text
        holder.nameNote.text = mListNotes[position].name
    }

    override fun getItemCount(): Int = mListNotes.size

    fun setList(list:List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }
}