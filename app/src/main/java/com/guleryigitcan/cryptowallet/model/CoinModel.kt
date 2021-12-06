package com.guleryigitcan.cryptowallet.model

data class CoinModel(
    val name:String,
    val image:String,
    val current_price:Double,
    val price_change_percentage_24h:Double
)
