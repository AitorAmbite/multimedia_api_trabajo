package com.example.trabajo_api

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class ViewModelActivityMain: ViewModel() {
    companion object{
        suspend fun retrieveCoins(){
            var listaMonedas = mutableListOf<CoinBasic>()
            val client = OkHttpClient()
            var urlBasic = "https://api.coinpaprika.com/v1/coins"

            val request = Request.Builder()
                .url(urlBasic)
                .build()
            val call = client.newCall(request)
            call.enqueue()
        }
    }
}