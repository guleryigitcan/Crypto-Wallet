package com.guleryigitcan.cryptowallet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guleryigitcan.cryptowallet.api.CoinsRetrofitFactory
import com.guleryigitcan.cryptowallet.model.CoinListModel
import com.guleryigitcan.cryptowallet.model.CoinModel
import com.guleryigitcan.cryptowallet.model.CoinDetailModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinViewModel:ViewModel() {

    private val _coinList= MutableLiveData<List<CoinModel>>()
    val coinList get() =_coinList
    private val _searchedCoin=MutableLiveData<List<CoinDetailModel>>()
    val searchedCoin get() = _searchedCoin



    fun getData(){
        CoinsRetrofitFactory.instance.service?.getCoins()?.enqueue(object : Callback<CoinListModel>{
            override fun onResponse(
                call: Call<CoinListModel>?,
                response: Response<CoinListModel>?
            ) {
                val listOfCoins=response?.body()
                _coinList.value=listOfCoins
            }

            override fun onFailure(call: Call<CoinListModel>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    fun searchCoin(coinId:String){
        CoinsRetrofitFactory.instance.service?.searchCoins(coinId)?.enqueue((object : Callback<CoinDetailModel> {
            override fun onResponse(call: Call<CoinDetailModel>?, response: Response<CoinDetailModel>?) {
                val searched=response?.body()
                _searchedCoin.value= listOf(response!!?.body())


            }

            override fun onFailure(call: Call<CoinDetailModel>?, t: Throwable?) {

            }

        }))
    }


}




