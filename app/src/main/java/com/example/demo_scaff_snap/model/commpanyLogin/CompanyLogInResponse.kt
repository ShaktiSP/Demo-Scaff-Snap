package com.example.demo_scaff_snap.model.commpanyLogin

data class CompanyLogInResponse(
    val `data`: Data,
    val message: String
)

data class Data(
    val address: String,
    val countryCode: String,
    val email: String,
    val id: String,
    val image: String,
    val isApproved: String,
    val latitude: Double,
    val longitude: Double,
    val mobileNumber: String,
    val name: String,
    val user_type: String
)