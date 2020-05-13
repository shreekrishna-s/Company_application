package com.example.navigationdrawer.model

import com.google.gson.annotations.SerializedName

data class Employee(val id:Int,
                    @SerializedName("username")
                    val name:String,
                    val email:String ) {

}
