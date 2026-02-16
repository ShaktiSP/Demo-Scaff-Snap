package com.example.demo_scaff_snap.network.repository

import com.example.demo_scaff_snap.dataStore.IPreferenceDataStoreAPI
import com.example.demo_scaff_snap.dataStore.PrefKeys
import com.example.demo_scaff_snap.model.commpanyLogin.CompanyLogInRequest
import com.example.demo_scaff_snap.model.commpanyLogin.CompanyLogInResponse
import com.example.demo_scaff_snap.model.login.LoginRequest
import com.example.demo_scaff_snap.model.login.LoginResponse
import com.example.demo_scaff_snap.network.ApiService
import com.example.demo_scaff_snap.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val preferenceDataStore: IPreferenceDataStoreAPI
) {

    // Login State
    private val _loginState = MutableStateFlow<Resource<LoginResponse>>(Resource.None())
    val loginState: StateFlow<Resource<LoginResponse>> = _loginState

    // Company Login State
    private val _companyLoginState = MutableStateFlow<Resource<CompanyLogInResponse>>(Resource.None())
    val companyLoginState: StateFlow<Resource<CompanyLogInResponse>> = _companyLoginState

    /**
     * Project Manager Login
     */
    suspend fun login(request: LoginRequest) {
        _loginState.value = Resource.Loading()
        try {
            val response = apiService.signIn(request)

            _loginState.value = when {
                response.isSuccessful -> {
                    val body = response.body()
                    if (body != null) {
                        // Save auth data to preference
                        preferenceDataStore.putPreference(PrefKeys.IS_LOGIN, true)
                        preferenceDataStore.putPreference(PrefKeys.AUTH_KEY, body.token ?: "")

                        Resource.Success(
                            data = body,
                            message = "Login Successful",
                            code = response.code()
                        )
                    } else {
                        Resource.Error(
                            message = "Empty response body",
                            code = response.code()
                        )
                    }
                }
                response.code() == 401 -> {
                    Resource.Error(
                        message = "Invalid credentials",
                        code = response.code()
                    )
                }
                response.code() == 400 -> {
                    Resource.Error(
                        message = response.message() ?: "Bad request",
                        code = response.code()
                    )
                }
                else -> {
                    Resource.Error(
                        message = response.message() ?: "Unknown error",
                        code = response.code()
                    )
                }
            }
        } catch (e: IOException) {
            _loginState.value = Resource.InternetError(
                message = "Network error: ${e.message ?: "No internet connection"}"
            )
        } catch (e: Exception) {
            _loginState.value = Resource.Error(
                message = e.localizedMessage ?: "Unknown error occurred"
            )
        }
    }

    /**
     * Company Registration/Login
     */
    suspend fun companyLogin(request: CompanyLogInRequest) {
        _companyLoginState.value = Resource.Loading()
        try {
            val response = apiService.onCompanyLogIn(request)

            _companyLoginState.value = when {
                response.isSuccessful -> {
                    val body = response.body()
                    if (body != null) {
                        Resource.Success(
                            data = body,
                            message = "Company registered successfully",
                            code = response.code()
                        )
                    } else {
                        Resource.Error(
                            message = "Empty response body",
                            code = response.code()
                        )
                    }
                }
                response.code() == 400 -> {
                    Resource.Error(
                        message = response.message() ?: "Invalid company data",
                        code = response.code()
                    )
                }
                else -> {
                    Resource.Error(
                        message = response.message() ?: "Registration failed",
                        code = response.code()
                    )
                }
            }
        } catch (e: IOException) {
            _companyLoginState.value = Resource.InternetError(
                message = "Network error: ${e.message ?: "No internet connection"}"
            )
        } catch (e: Exception) {
            _companyLoginState.value = Resource.Error(
                message = e.localizedMessage ?: "Unknown error occurred"
            )
        }
    }

    /**
     * Clear authentication data on logout
     */
    suspend fun logout() {
        preferenceDataStore.putPreference(PrefKeys.IS_LOGIN, false)
        preferenceDataStore.putPreference(PrefKeys.AUTH_KEY, "")
    }
}