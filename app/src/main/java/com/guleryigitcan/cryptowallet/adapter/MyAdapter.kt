package com.guleryigitcan.cryptowallet.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guleryigitcan.cryptowallet.R

class MyAdapter:RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var name= arrayOf("Bitcoin","Etherium","LiteCoin","XRP","RBX")
    private var price= arrayOf("28,902.00$","2,802.00$","25.00$","5.00$","0.25$")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.item_coins,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.coinName.text=name[position]
        holder.coinPrice.text=price[position]
    }

    override fun getItemCount(): Int {
       return name.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var coinImage:ImageView
        var coinName:TextView
        var coinPrice:TextView

        init {
            coinImage=itemView.findViewById(R.id.coinImage)
            coinName=itemView.findViewById(R.id.coinNameText)
            coinPrice=itemView.findViewById(R.id.coinPriceText)
        }
    }
}