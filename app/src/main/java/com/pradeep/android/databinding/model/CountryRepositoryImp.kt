package com.pradeep.android.databinding.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepositoryImp(private var countryApis: CountryApis = RetrofitRepository().getCountryApis()) : CountryRepository{

    companion object{
        var TAG : String = "CountryRepositoryImp"
    }
    override fun getCountryInfo(name: String) : LiveData<Country> {
        val data = MutableLiveData<Country>()
        countryApis.getCountry(name).enqueue(object : Callback<List<Country>>{

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                data.value = response.body()?.get(0)
                Log.i(TAG, response.body().toString())
            }
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.i(TAG, t.message.toString())
                data.value = null
            }
        })
        return data
    }
}