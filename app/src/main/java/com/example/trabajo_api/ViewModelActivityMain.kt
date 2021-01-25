package com.example.trabajo_api

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class ViewModelActivityMain: ViewModel() {
    var listaMonedas = mutableListOf<CoinBasic>()
    val client = OkHttpClient()
    var urlBasic = "https://api.coinpaprika.com/v1/coins"

    suspend fun retrieveCoins(): MutableList<CoinBasic>{
        return withContext(Dispatchers.IO){
            val request = Request.Builder()
                .url(urlBasic)
                .build()

            return@withContext mutableListOf<CoinBasic>()
        }
    }
}