package br.com.fiap.recicheck.service

import com.example.consumoapi.model.Coordenadas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServicoCoordenadas {
    @GET("direct?")
    fun getLatLon(
        @Query("q") lugar: String,
        @Query("limit") limit: Int = 1,
        @Query("appid") appid: String = "33bead2c309049ca821a952d8eaaf513"
    ): Call <List<Coordenadas>>
}



