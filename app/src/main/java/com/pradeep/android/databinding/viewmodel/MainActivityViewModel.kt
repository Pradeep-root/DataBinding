package com.pradeep.android.databinding.viewmodel

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.pradeep.android.databinding.model.Country
import com.pradeep.android.databinding.model.CountryRepository
import com.pradeep.android.databinding.model.CountryRepositoryImp

class MainActivityViewModel(private var repository: CountryRepository = CountryRepositoryImp()) : ViewModel() {

    var countryData : MediatorLiveData<Country> = MediatorLiveData()

    fun getCountryData(name : String){
        countryData.addSource(repository.getCountryInfo(name)){
            // You can perform any business logic here if UI required
            // in my case I am sending Country object as it is
            countryData.postValue(it)
            Log.i("MainActivityViewModel :", it.toString())
        }
    }
}