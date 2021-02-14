package com.example.trabajo_api.CoinSpecificLogic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.trabajo_api.databinding.CoinSpecificActivityBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinSpecificActivity : AppCompatActivity() {
    lateinit var binding: CoinSpecificActivityBinding
    lateinit var model : viewModelSpecific

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CoinSpecificActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        model = ViewModelProvider(this).get(viewModelSpecific::class.java)
        val id = intent.getStringExtra(ID)

        GlobalScope.launch(Dispatchers.IO) {
            id?.let {
                val resultado = model.getResults(id).await()
                Log.d("Prueba",resultado.toString())
                withContext(Dispatchers.Main){
                    model.changeLoading(binding.root)
                    resultado?.let { itResultado -> model.setData(binding.root, itResultado) }
                }

            }
        }
    }

    companion object {
        const val ID = "ID_COIN"

        fun createSpecificActivity(context: Context, id_valor: String) {
            var intent = Intent(context, CoinSpecificActivity::class.java)
            intent.putExtra(ID, id_valor)
            context.startActivity(intent)
        }
    }
}