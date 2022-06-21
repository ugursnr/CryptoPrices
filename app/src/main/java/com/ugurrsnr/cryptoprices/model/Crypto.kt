package com.ugurrsnr.cryptoprices.model

import com.google.gson.annotations.SerializedName

data class Crypto(
    @SerializedName("currency")
    val currencyName : String,

    @SerializedName("price")
    val currencyPrice : String,

    @SerializedName("max_supply", alternate = ["circulating_supply"])
    val currencyMaxSupply : String,

    @SerializedName("market_cap")
    val currencyMarketCap : String
) {
}