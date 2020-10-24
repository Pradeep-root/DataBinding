package com.pradeep.android.databinding.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.pradeep.android.databinding.model.Country
import com.pradeep.android.databinding.model.CountryRepository
import com.pradeep.android.databinding.model.CountryRepositoryImp

class MainActivityViewModel(private var repository: CountryRepository = CountryRepositoryImp()) : ViewModel() {

    var countryData : MediatorLiveData<Country> = MediatorLiveData()
    var countryName = ObservableField<String>("")

    fun getCountryDataWeb(){
        countryData.addSource(repository.getCountryInfo(countryName.get()?:"")){
            // You can perform any business logic here if UI required
            // in my case I am sending Country object as it is
            countryData.postValue(it)
            Log.i("MainActivityViewModel :", it.toString())
        }
    }
}