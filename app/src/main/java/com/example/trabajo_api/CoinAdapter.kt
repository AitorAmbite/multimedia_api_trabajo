package com.example.trabajo_api

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajo_api.CoinSpecificLogic.CoinSpecificActivity
import com.example.trabajo_api.coinRelated.CoinBasic
import com.example.trabajo_api.coinRelated.CoinSpecific
import com.example.trabajo_api.databinding.CoinItemBinding
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinAdapter (): RecyclerView.Adapter<CoinAdapter.coinAdapterViewHolder>(){

    var coinList : List<CoinBasic>? = null
    lateinit var recyclerView: RecyclerView

    class coinAdapterViewHolder(var view: CoinItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

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
        holder.itemView.setOnClickListener {
            val posicion = recyclerView.getChildLayoutPosition(it)

            coinList?.let{ itCoin ->
                CoinSpecificActivity.createSpecificActivity(it.context,itCoin[posicion].id)
            }
        }
    }

    override fun getItemCount(): Int {
        coinList?.let {
            return it.size
        }
        return 0
    }

    suspend fun setCoinList(lista: List<CoinBasic>?){
        coinList = lista
        withContext(Dispatchers.Main){
            notifyDataSetChanged()
        }
    }
}