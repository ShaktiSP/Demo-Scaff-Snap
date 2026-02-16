package com.example.demo_scaff_snap.network

import com.example.demo_scaff_snap.model.commpanyLogin.CompanyLogInRequest
import com.example.demo_scaff_snap.model.commpanyLogin.CompanyLogInResponse
import com.example.demo_scaff_snap.model.login.LoginRequest
import com.example.demo_scaff_snap.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/projectManager/login")
    suspend fun signIn(@Body body: LoginRequest): Response<LoginResponse>

    @POST("api/v1/company/registerCompany")
    suspend fun onCompanyLogIn(@Body body: CompanyLogInRequest): Response<CompanyLogInResponse>


}