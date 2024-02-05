package com.farzin.mvi_playground.api

import com.farzin.mvi_playground.model.Animal
import retrofit2.http.GET

interface AnimalApi {

    @GET("animals.json")
    suspend fun getAnimals(): List<Animal>

}