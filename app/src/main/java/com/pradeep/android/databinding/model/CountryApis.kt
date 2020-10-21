package com.pradeep.android.databinding.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApis {

    @GET("rest/v2/name/{name}?fullText=true")
    fun getCountry(@Path("name") name : String) : Call<List<Country>>

}