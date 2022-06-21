package com.ugurrsnr.cryptoprices.service

import com.ugurrsnr.cryptoprices.model.Crypto
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CryptoAPIService {

    private val api = Retrofit.Builder()
        .baseUrl(myURL.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CryptoAPI::class.java)


    fun getData() : Single<List<Crypto>> {
        return api.getCryptoData()
    }
}