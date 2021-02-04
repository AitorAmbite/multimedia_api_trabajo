package com.example.trabajo_api

import androidx.lifecycle.ViewModel
import com.example.trabajo_api.coinRelated.CoinBasic
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.OkHttpClient
import okhttp3.Request

class ViewModelActivityMain: ViewModel() {
    suspend fun getResults() = GlobalScope.async{

    }
}