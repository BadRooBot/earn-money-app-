package com.blacklotus.makasibbasita.model

import android.os.Parcel
import android.os.Parcelable

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(

    val email: String?,
    val password: String


)
data class LoginResponse(

    val userId: String?,
    val username:String?,
    val email: String?,
    val imageUrl:String?,
    val points:Int,
    val coins:Int
    // Add any other properties you expect in the response
)

data class RegisterResponse(

    val userId: String?,
    val username:String?,
    val email: String?,
    val imageUrl:String?,
    val points:Int,
    val coins:Int
    // Add any other properties you expect in the response
)