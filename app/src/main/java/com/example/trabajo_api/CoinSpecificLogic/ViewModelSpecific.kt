package com.example.trabajo_api.CoinSpecificLogic

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.trabajo_api.DownloaderManager
import com.example.trabajo_api.coinRelated.CoinSpecific
import kotlinx.android.synthetic.main.activity_main.view.progressBar_carga
import kotlinx.android.synthetic.main.coin_specific_activity.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class viewModelSpecific : ViewModel() {
    suspend fun getResults(id:String) = GlobalScope.async(Dispatchers.IO){
        val data = DownloaderManager.downloadSpecificCoin(id)
        print(data)
        data
    }

    fun changeLoading(view: View){
        view.progressBar_carga.visibility = View.GONE
        view.cardview_specific.visibility= View.VISIBLE
    }

    fun setData(view:View,moneda: CoinSpecific){
        view.tv_specific_name.text = moneda.name
        view.tv_specificCoin_symbol.text = moneda.symbol
        if(moneda.openSource){
            view.tv_specificCoin_type.text = "si"
        }else{
            view.tv_specificCoin_type.text = "no"
        }

        view.tv_specificCoin_type.text = moneda.openSource.toString()
        view.tv_specificCoin_rank.text = moneda.rank.toString()
        view.tv_description_coin.text = moneda.description
    }

}