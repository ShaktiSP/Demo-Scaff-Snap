package com.example.demo_scaff_snap.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_scaff_snap.model.commpanyLogin.CompanyLogInRequest
import com.example.demo_scaff_snap.model.login.LoginRequest
import com.example.demo_scaff_snap.network.repository.AuthRepository
import com.example.demo_scaff_snap.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    // Expose StateFlows from repository
    val loginState: StateFlow<Resource<*>> = authRepository.loginState as StateFlow<Resource<*>>
    val companyLoginState: StateFlow<Resource<*>> = authRepository.companyLoginState as StateFlow<Resource<*>>

    /**
     * Project Manager Login
     * @param request LoginRequest object containing company ID, email, and password
     */
    fun login(request: LoginRequest) {
        viewModelScope.launch {
            authRepository.login(request)
        }
    }

    /**
     * Company Registration/Login
     * @param request CompanyLogInRequest object containing company details
     */
    fun companyLogin(request: CompanyLogInRequest) {
        viewModelScope.launch {
            authRepository.companyLogin(request)
        }
    }

    /**
     * Logout user
     */
    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
        }
    }

    override fun onCleared() {
        super.onCleared()
        // Cleanup if needed
    }
}