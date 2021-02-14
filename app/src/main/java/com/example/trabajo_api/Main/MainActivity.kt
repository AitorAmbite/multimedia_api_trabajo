package com.example.trabajo_api.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajo_api.CoinAdapter
import com.example.trabajo_api.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        GlobalScope.launch (Dispatchers.IO){
            val resultado = model.getResults().await()
            withContext(Dispatchers.Main){
                model.changeLoading(binding.root)
            }
            adapter.setCoinList(resultado)
        }
    }

    fun createRecyclerView(){
        adapter = CoinAdapter()
        binding.recyclerViewCoins.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCoins.adapter = adapter

    }


}