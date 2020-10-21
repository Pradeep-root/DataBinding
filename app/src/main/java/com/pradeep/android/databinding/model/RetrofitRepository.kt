package com.pradeep.android.databinding.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository {

    companion object{
        var URL : String = "https://restcountries.eu"
    }

    private fun getRetrofitClient() : Retrofit {
        return  Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    public fun getCountryApis() : CountryApis {
        return getRetrofitClient().create(CountryApis::class.java)
    }
}