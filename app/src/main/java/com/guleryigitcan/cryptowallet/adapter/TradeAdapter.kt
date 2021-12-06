package com.guleryigitcan.cryptowallet.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guleryigitcan.cryptowallet.R
import com.guleryigitcan.cryptowallet.model.CoinModel

class TradeAdapter(private val list:List<CoinModel>):RecyclerView.Adapter<TradeAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        private val coinName by lazy { itemView.findViewById<TextView>(R.id.coinNameText) }
        private val coinPrice by lazy { itemView.findViewById<TextView>(R.id.coinPriceText) }
        private val coinImage by lazy { itemView.findViewById<ImageView>(R.id.coinImage) }
        private val coinChangePercentage by lazy { itemView.findViewById<TextView>(R.id.coinChangePercentage) }

        fun bind(coin:CoinModel){

            coinName.text=coin.name
            coinPrice.text= coin.current_price.toString()+"$"
            Glide.with(coinImage.context)
                .load(coin.image)
                .circleCrop()
                .into(coinImage)
            coinChangePercentage.text=coin.price_change_percentage_24h.toString()


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradeAdapter.CoinViewHolder {
        return CoinViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_coins,parent,false))

    }

    override fun onBindViewHolder(holder: TradeAdapter.CoinViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}