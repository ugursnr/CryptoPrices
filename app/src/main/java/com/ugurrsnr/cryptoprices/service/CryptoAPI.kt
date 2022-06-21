package com.ugurrsnr.cryptoprices.service

import com.ugurrsnr.cryptoprices.model.Crypto
import io.reactivex.Single
import retrofit2.http.GET


interface CryptoAPI {

    @GET(myURL.URL_EXTENSION)
    fun getCryptoData() : Single<List<Crypto>>


}