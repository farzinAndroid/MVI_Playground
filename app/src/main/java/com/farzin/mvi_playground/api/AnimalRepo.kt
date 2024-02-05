package com.farzin.mvi_playground.api

class AnimalRepo(private val api: AnimalApi) {

    suspend fun getAnimals() = api.getAnimals()

}