package com.ugurrsnr.cryptoprices.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import com.ugurrsnr.cryptoprices.model.Crypto
import com.ugurrsnr.cryptoprices.view.MainFragmentDirections

import com.ugurrsnr.cryptoprices.databinding.RecyclerRowBinding

class CryptoAdapter(val cryptoList : ArrayList<Crypto>) : RecyclerView.Adapter<CryptoAdapter.CryptoHolder>() {

    class CryptoHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CryptoHolder(binding)
    }


    override fun onBindViewHolder(holder: CryptoHolder, position: Int) {
        holder.binding.currencyNameText.text = cryptoList[position].currencyName
        holder.binding.currencyPriceText.text = cryptoList[position].currencyPrice

        holder.itemView.setOnClickListener {
            val actionToDetailsFragment = MainFragmentDirections.actionMainFragmentToDetailsFragment()
            actionToDetailsFragment.cryptoName = cryptoList[position].currencyName
            actionToDetailsFragment.cryptoPrice = cryptoList[position].currencyPrice
            actionToDetailsFragment.cryptoMarketCap = cryptoList[position].currencyMarketCap
            actionToDetailsFragment.cryptoMaxSupply = cryptoList[position].currencyMaxSupply

            Navigation.findNavController(it).navigate(actionToDetailsFragment)
        }


    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateCryptoList(cryptoListNEW : List<Crypto>){
        cryptoList.clear()
        cryptoList.addAll(cryptoListNEW)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }
}