package com.example.demo_scaff_snap.model

data class LoginRequest(
    val cmpId: String,
    val email: String,
    val password: String,
    val user_type: String
)