package com.example.demo_scaff_snap.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_scaff_snap.dataStore.IPreferenceDataStoreAPI
import com.example.demo_scaff_snap.model.LoginRequest
import com.example.demo_scaff_snap.network.AuthRepository
import com.example.demo_scaff_snap.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val iPreferenceDataStoreAPI: IPreferenceDataStoreAPI
) : ViewModel() {

    val loginState = repository.loginResponseShared.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = Resource.None()
    )

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            repository.login(request)
        }
    }


}