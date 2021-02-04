package com.example.trabajo_api

import com.example.trabajo_api.coinRelated.CoinBasic
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject

class DownloaderManager {
    companion object{
        suspend fun downloadData(): String? {
            val client = OkHttpClient()
            val url = "https://api.coinpaprika.com/v1/coins"
            val request = Request.Builder()
                .url(url)
                .build()

            val call = client.newCall(request)
            val response = call.execute()
            println(response.body?.string())

            return response.body?.string()
        }
    }
}