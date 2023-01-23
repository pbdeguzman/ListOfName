package com.example.listofname.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listofname.databinding.ActivityMainBinding
import com.example.listofname.ui.adapter.PersonRecycleAdapter
import com.example.listofname.ui.viewmodel.MainViewModel
import com.example.listofname.ui.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this,factory)[MainViewModel::class.java]

        initializedAdapter()
    }

    private fun initializedAdapter() {
        viewModel.initMockData()
        binding.rvPerson.layoutManager = LinearLayoutManager(this)
        observeData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeData() {
        viewModel.list.observe(this) {
            binding.rvPerson.adapter = PersonRecycleAdapter(it)
            binding.rvPerson.adapter?.notifyDataSetChanged()
        }
    }
}