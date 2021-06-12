package com.example.restoapp

data class Resto (
    var name: String = "",
    var city : String = "",
    var rating : Double = 0.0,
    var photo : Int = 0,
    var menuFoods : Array<String> = arrayOf(),
)