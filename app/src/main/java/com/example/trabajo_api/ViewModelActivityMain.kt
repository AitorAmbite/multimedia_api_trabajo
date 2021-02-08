package com.example.trabajo_api

import android.provider.Settings
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import com.example.trabajo_api.coinRelated.CoinBasic
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class ViewModelActivityMain: ViewModel() {
    suspend fun getResults() = GlobalScope.async(Dispatchers.IO){
        val data = DownloaderManager.downloadAllCoins()
        data?.let{
            DownloaderManager.transformJsonToGson(it)
        }
    }

    fun changeLoading(view : View){
        view.progressBar_carga.visibility = View.GONE
        view.tv_loading.visibility = View.GONE
    }
}