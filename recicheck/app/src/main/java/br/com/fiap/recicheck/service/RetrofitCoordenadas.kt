package br.com.fiap.recicheck.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitCoordenadas {
    private val URL = "https://api.openweathermap.org/geo/1.0/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getCoordenadaService(): ServicoCoordenadas{
        return  retrofitFactory.create(ServicoCoordenadas::class.java)
    }
}