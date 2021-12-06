package com.guleryigitcan.cryptowallet.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guleryigitcan.cryptowallet.CoinViewModel
import com.guleryigitcan.cryptowallet.R
import com.guleryigitcan.cryptowallet.adapter.TradeSearchAdapter

class CoinSearchFragment : Fragment() {


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

        val view= inflater.inflate(R.layout.fragment_coin_search, container, false)

        val searchEditText=view.findViewById<EditText>(R.id.editTextSearch)

        val recyclerView=view.findViewById<RecyclerView>(R.id.recyclerViewSearchResults)

        coinViewModel.searchedCoin.observe(requireActivity()){list->
            if(list[0]!=null){
                layoutManager=LinearLayoutManager(requireContext())
                recyclerView.layoutManager=layoutManager
                adapter=TradeSearchAdapter(list)
                recyclerView.adapter=adapter
            }

        }

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                coinViewModel.searchCoin(p0.toString())
            }

        })



        return view
    }


}