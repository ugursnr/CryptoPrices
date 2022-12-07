package com.ugurrsnr.cryptoprices.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurrsnr.cryptoprices.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var cryptoName : String
    private lateinit var cryptoPrice : String
    private lateinit var cryptoMarketCap : String
    private lateinit var cryptoMaxSupply : String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            cryptoName = DetailsFragmentArgs.fromBundle(it).cryptoName
            cryptoPrice = DetailsFragmentArgs.fromBundle(it).cryptoPrice
            cryptoMarketCap = DetailsFragmentArgs.fromBundle(it).cryptoMarketCap
            cryptoMaxSupply = DetailsFragmentArgs.fromBundle(it).cryptoMaxSupply

        }

        binding.apply {
            currencyNameDetailsText.text = cryptoName
            currencyPriceDetailsText.text = cryptoPrice
            currencyMarketCapDetailsText.text = cryptoMarketCap
            currencyMaxSupplyDetailsText.text = cryptoMaxSupply
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}