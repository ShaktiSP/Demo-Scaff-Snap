package com.example.demo_scaff_snap.network

import com.example.demo_scaff_snap.model.LoginRequest
import com.example.demo_scaff_snap.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("sign-in-with-email")
    suspend fun signIn(@Body body: LoginRequest): Response<LoginResponse>


}