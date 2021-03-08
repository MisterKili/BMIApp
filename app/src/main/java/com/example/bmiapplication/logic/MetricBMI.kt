package com.example.bmiapplication.logic

import kotlin.math.pow

class MetricBMI : BMI {

    /**
     * mass in kg
     * height in cm
     */
    override fun value(mass: Double, height: Double): Double {
        if (argumentsAreInvalid(mass, height)) {
            throwIllegalArgumentsException()
        }
        val heightInMeters = height / 100
        return mass / heightInMeters.pow(2)
    }
}