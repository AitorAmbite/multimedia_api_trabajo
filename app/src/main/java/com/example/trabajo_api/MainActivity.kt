package com.example.trabajo_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajo_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var model : ViewModelActivityMain
    lateinit var adapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        model = ViewModelProvider(this).get(ViewModelActivityMain::class.java)

        createRecyclerView()


    }

    fun createRecyclerView(){
        adapter = CoinAdapter()
        binding.recyclerViewCoins.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCoins.adapter = adapter

    }


}