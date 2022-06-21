package com.ugurrsnr.cryptoprices.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurrsnr.cryptoprices.adapter.CryptoAdapter
import com.ugurrsnr.cryptoprices.databinding.FragmentMainBinding
import com.ugurrsnr.cryptoprices.model.Crypto
import com.ugurrsnr.cryptoprices.viewmodel.MainFragmentViewModel


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var cryptoAdapter = CryptoAdapter(arrayListOf())
    private lateinit var cryptoList : List<Crypto>

    private lateinit var viewModel : MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.refreshCryptoData()

        binding.recyclerView.layoutManager= LinearLayoutManager(context)
        binding.recyclerView.adapter = cryptoAdapter

        observeCryptoData()

    }


    private fun observeCryptoData(){

        viewModel.allCryptoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                cryptoAdapter.updateCryptoList(it)
            }
        })

        viewModel.isThereError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if(it){
                    Toast.makeText(context,"Error while loading data", Toast.LENGTH_LONG ).show()
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}