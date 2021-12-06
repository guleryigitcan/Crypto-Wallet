package com.guleryigitcan.cryptowallet.model

data class CoinDetailModel(

    val id:String,
    val name:String,
    val image:Image,
    val market_data:MarketData

){
    data class Image(
        val large:String
    )

    data class MarketData(
        val current_price:CurrentPrice,
        val price_change_percentage_24h:Double
    )
    {
        data class CurrentPrice(
            val usd:Double
        )
    }
}
