package com.example.trabajo_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajo_api.coinRelated.CoinBasic
import com.example.trabajo_api.databinding.CoinItemBinding

class CoinAdapter (): RecyclerView.Adapter<CoinAdapter.coinAdapterViewHolder>(){

    var coinList = mutableListOf<CoinBasic>(CoinBasic("btc-btc","bitcoin","btc",false,true))

    class coinAdapterViewHolder(var view: CoinItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coinAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
        val adaptador = CoinItemBinding.inflate(view,parent,false)
        return coinAdapterViewHolder(adaptador)
    }

    override fun onBindViewHolder(holder: coinAdapterViewHolder, position: Int) {
        coinList?.let{
            holder.view.tvCoinId.text = it[position].id
            holder.view.tvCoinName.text = it[position].name
        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}