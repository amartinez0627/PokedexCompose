package com.example.android.pokedexcompose.repository

import com.example.android.pokedexcompose.data.remote.PokeApi
import com.example.android.pokedexcompose.data.remote.responses.Pokemon
import com.example.android.pokedexcompose.data.remote.responses.PokemonList
import com.example.android.pokedexcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit,offset)
        }catch (e: Exception){
            return Resource.Error("An Unknown error occurred")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error("An Unknown error occurred")
        }

        return Resource.Success(response)
    }
}