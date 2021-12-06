package com.guleryigitcan.cryptowallet.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinsRetrofitFactory private constructor(){

    var service:CoinApi? = null

    init {

        val client = okhttp3.OkHttpClient.Builder()
            .build()

        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(CoinApi::class.java)


    }

    companion object {
        private var INSTANCE: CoinsRetrofitFactory? = null

        val instance: CoinsRetrofitFactory
            get()  {
                if(INSTANCE == null) {
                    INSTANCE = CoinsRetrofitFactory()
                }


                return INSTANCE!!
            }
    }
}