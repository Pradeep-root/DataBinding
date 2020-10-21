package com.pradeep.android.databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pradeep.android.databinding.R
import com.pradeep.android.databinding.viewmodel.MainActivityViewModel

private lateinit var viewModel : MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.countryData.observe(this, Observer {
            Log.i("CountryData ", it.toString())
        })

        viewModel.getCountryData("India")
    }
}