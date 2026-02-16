package com.example.demo_scaff_snap.dataStore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

class PrefKeys {
    companion object{
        val DEVICE_TOKEN = stringPreferencesKey("device_token")
        val AUTH_KEY = stringPreferencesKey("auth_key")
        val IS_LOGIN = booleanPreferencesKey("is_login")
        val IS_ONBOARDING_LOGIN = booleanPreferencesKey("is_onboarding_login")
    }
}