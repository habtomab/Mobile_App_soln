package com.example.lab05_userlogin

import java.io.Serializable


data class User (var firstName:String,var lastName:String,val userName:String,var password:String ):
    Serializable {
}
