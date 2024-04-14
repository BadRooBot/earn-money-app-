package com.blacklotus.makasibbasita.model
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Body

interface AuthService {
    @POST("login")
     fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("signup")
    fun register(@Body newuser:RegisterRequest):Call<RegisterResponse>


}