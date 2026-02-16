package com.example.demo_scaff_snap.utils

sealed class Resource<out T>(
    open val data: T? = null,
    open val message: String? = null,
    open val code: Int? = null
) {
    class Loading<T> : Resource<T>()

    class Success<T>(
        override val data: T?,
        override val message: String? = null,
        override val code: Int? = null
    ) : Resource<T>(data, message, code)

    class Error<T>(
        override val message: String? = null,
        override val code: Int? = null,
        override val data: T? = null
    ) : Resource<T>(data, message, code)

    class InternetError<T>(
        override val message: String? = "No internet connection",
        override val code: Int? = null
    ) : Resource<T>(null, message, code)

    class None<T> : Resource<T>()
}

// Extension functions for easier use
fun <T> Resource<T>.isLoading(): Boolean = this is Resource.Loading
fun <T> Resource<T>.isSuccess(): Boolean = this is Resource.Success
fun <T> Resource<T>.isError(): Boolean = this is Resource.Error
fun <T> Resource<T>.isInternetError(): Boolean = this is Resource.InternetError

fun <T> Resource<T>.getOrNull(): T? = (this as? Resource.Success)?.data