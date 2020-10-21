package com.pradeep.android.databinding.model

import androidx.lifecycle.LiveData

interface CountryRepository{

    fun getCountryInfo(name : String) : LiveData<Country>
}