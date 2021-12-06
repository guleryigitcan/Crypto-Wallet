package com.guleryigitcan.cryptowallet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.guleryigitcan.cryptowallet.CoinViewModel
import com.guleryigitcan.cryptowallet.R
import com.guleryigitcan.cryptowallet.adapter.TradeSearchAdapter


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private var layoutManager:RecyclerView.LayoutManager?=null
    private val coinViewModel by viewModels<CoinViewModel> ()
    private var adapter :RecyclerView.Adapter<TradeSearchAdapter.CoinSearchViewHolder>?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_profile, container, false)



        return view
    }


}