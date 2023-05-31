package com.example.android.pokedexcompose.util

sealed class Resource<T>(val data: T? = null, val message: String?= null) {
    class Success<T>(data: T): Resource<T>(data,null)
    class Error<T>(message: String, data: T? = null): Resource<T>(data,message)
}