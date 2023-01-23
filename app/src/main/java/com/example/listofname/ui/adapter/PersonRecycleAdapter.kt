package com.example.listofname.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listofname.databinding.PersonItemBinding
import com.example.listofname.model.Person

class PersonRecycleAdapter(
    private val arrayList: ArrayList<Person>
): RecyclerView.Adapter<PersonRecycleAdapter.PersonViewHolder>() {
    lateinit var binding: PersonItemBinding

    inner class PersonViewHolder(binding: PersonItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        binding = PersonItemBinding.inflate( LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.itemView.apply {
            binding.tvName.text = arrayList[position].name
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}