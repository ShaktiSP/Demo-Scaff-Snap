package com.example.demo_scaff_snap.network

import com.example.demo_scaff_snap.model.LoginRequest
import com.example.demo_scaff_snap.model.LoginResponse
import com.example.demo_scaff_snap.utils.Resource
import kotlinx.coroutines.flow.MutableSharedFlow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val api: ApiService,
) {
    private val loginResponse = MutableSharedFlow<Resource<LoginResponse?>>()
    val loginResponseShared: MutableSharedFlow<Resource<LoginResponse?>> = loginResponse

    ////// Login Function //////////////////
    suspend fun login(request: LoginRequest) {
        loginResponse.emit(Resource.Loading())
        val response = runCatching {
            api.signIn(request)
        }
        if (response.isFailure) {
            if (response.exceptionOrNull()!! is IOException) {
                loginResponse.emit(Resource.InternetError())
            } else {
                loginResponse.emit(
                    Resource.Error(
                        response.exceptionOrNull()!!.localizedMessage ?: "Unknown error"
                    )
                )
            }
            return
        }
        response.getOrNull()?.let { data ->
            if (data.isSuccessful) {
                data.body()?.let {
                    loginResponse.emit(Resource.Success(it, "Login Successful", data.code()))
                } ?: loginResponse.emit(Resource.Error("Empty response", data.code()))
            } else {
                loginResponse.emit(Resource.Error("Error: ${data.message()}", data.code()))
            }
        } ?: loginResponse.emit(Resource.Error("Response Null"))
    }

}