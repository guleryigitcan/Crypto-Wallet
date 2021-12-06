package com.guleryigitcan.cryptowallet.api

import com.guleryigitcan.cryptowallet.model.CoinListModel
import com.guleryigitcan.cryptowallet.model.CoinDetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    fun getCoins():Call<CoinListModel>

    @GET("coins/{id}")
    fun searchCoins(@Path("id")coinId:String):Call<CoinDetailModel>

}