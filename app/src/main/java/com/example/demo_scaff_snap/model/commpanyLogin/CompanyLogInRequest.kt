package com.example.demo_scaff_snap.model.commpanyLogin

data class CompanyLogInRequest(
    val address: String,
    val countryCode: String,
    val email: String,
    val image: String,
    val latitude: Double,
    val longitude: Double,
    val mobileNumber: String,
    val name: String,
    val password: String
)