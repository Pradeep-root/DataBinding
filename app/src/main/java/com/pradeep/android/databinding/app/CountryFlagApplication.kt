package com.pradeep.android.databinding.app

import android.app.Application
import retrofit2.Retrofit

class CountryFlagApplication : Application() {


    companion object{
        lateinit var retrofitClient : Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        }
}