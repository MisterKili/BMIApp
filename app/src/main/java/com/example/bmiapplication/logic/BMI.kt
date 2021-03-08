package com.example.bmiapplication.logic

interface BMI {

    fun argumentsAreInvalid(mass: Double, height: Double): Boolean {
        return mass <= 0.0 || height <= 0.0
    }

    fun throwIllegalArgumentsException(): Unit {
        throw IllegalArgumentException("Mass and height must be greater than 0")
    }

    fun value(mass: Double, height: Double): Double
}