package com.guleryigitcan.cryptowallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guleryigitcan.cryptowallet.R
import com.guleryigitcan.cryptowallet.model.CoinDetailModel

class TradeSearchAdapter(private val list:List<CoinDetailModel>):RecyclerView.Adapter<TradeSearchAdapter.CoinSearchViewHolder>() {

    inner class CoinSearchViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val coinName by lazy { itemView.findViewById<TextView>(R.id.coinNameText) }
        private val coinPrice by lazy { itemView.findViewById<TextView>(R.id.coinPriceText) }
        private val coinImage by lazy { itemView.findViewById<ImageView>(R.id.coinImage) }
        private val coinChangePercentage by lazy { itemView.findViewById<TextView>(R.id.coinChangePercentage) }
        fun bind(coin:CoinDetailModel){
            coinName.text=coin.name
            Glide.with(coinImage.context)
                .load(coin.image.large)
                .circleCrop()
                .into(coinImage)
            coinPrice.text=coin.market_data.current_price.usd.toString()+"$"
            coinChangePercentage.text=coin.market_data.price_change_percentage_24h.toString()

        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TradeSearchAdapter.CoinSearchViewHolder {
        return CoinSearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_coins,parent,false))
    }

    override fun onBindViewHolder(holderSearch: TradeSearchAdapter.CoinSearchViewHolder, position: Int) {

        holderSearch.bind(list[position])


    }

    override fun getItemCount(): Int {
        return list.size
    }

}