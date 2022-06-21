package com.ugurrsnr.cryptoprices.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurrsnr.cryptoprices.model.Crypto
import com.ugurrsnr.cryptoprices.service.CryptoAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainFragmentViewModel : ViewModel() {

    var cryptoListFromApi = listOf<Crypto>()
    private val disposable = CompositeDisposable()
    val allCryptoList = MutableLiveData<List<Crypto>>()
    val isThereError = MutableLiveData<Boolean>()

    fun refreshCryptoData(){
        getDataFromAPI()
    }

    private fun getDataFromAPI(){

        disposable.add(
            CryptoAPIService().getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Crypto>>(){
                    override fun onSuccess(t: List<Crypto>) {
                        allCryptoList.value = t
                        isThereError.value = false
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        isThereError.value = true
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}