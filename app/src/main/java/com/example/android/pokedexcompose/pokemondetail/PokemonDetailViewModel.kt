package com.example.android.pokedexcompose.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.android.pokedexcompose.data.remote.responses.Pokemon
import com.example.android.pokedexcompose.repository.PokemonRepositoryImpl
import com.example.android.pokedexcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repositoryImpl: PokemonRepositoryImpl
): ViewModel(){

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        return repositoryImpl.getPokemonInfo(pokemonName)
    }
}