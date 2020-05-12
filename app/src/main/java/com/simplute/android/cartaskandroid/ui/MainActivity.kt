package com.simplute.android.cartaskandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.simplute.android.cartaskandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: CarViewModelFactory
    private lateinit var viewModel: CarViewModel

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModelFactory = CarViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CarViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val adapter = CarAdapter()

        binding.ticketList.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshList()
            adapter.notifyDataSetChanged()

            // for refreshing icon to disappear
            binding.swipeRefresh.isRefreshing = false

        }

    }
}
