package com.example.demo_scaff_snap.model.login

data class LoginRequest(
    val companyId: String,
    val email: String,
    val password: String,
    val user_type: String
)