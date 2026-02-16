package com.example.demo_scaff_snap.network

import android.util.Log
import com.example.demo_scaff_snap.dataStore.IPreferenceDataStoreAPI
import com.example.demo_scaff_snap.dataStore.PrefKeys
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val store: IPreferenceDataStoreAPI
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        // Always required headers
        builder.addHeader("Accept", "application/json")
        builder.addHeader("Content-Type", "application/json; charset=utf-8")
        builder.addHeader(
            "x-client-key",
            "c6ac48ec34130134f5d4d0ed9226e33e0e3e875c3fb3ad12d669bbfa50024f33"
        )

        // Optional auth header
        val authKey = try {
            runBlocking { store.getFirstPreference(PrefKeys.AUTH_KEY, "") }
        } catch (e: Exception) {
            Log.e("AuthInterceptor", "Error getting auth key", e)
            ""
        }

        if (authKey.isNotEmpty()) {
            builder.addHeader("Authorization", "Bearer $authKey")
            Log.d("TAG", "intercept: $authKey")
        } else {
            Log.d("AuthInterceptor", "No auth token (login or public API)")
        }

        return chain.proceed(builder.build())
    }
}
