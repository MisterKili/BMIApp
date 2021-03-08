package com.example.bmiapplication.logic

import kotlin.math.pow

class ImperialBMI: BMI {

    /**
     * mass in lbs
     * height in in
     */
    override fun value(mass: Double, height: Double): Double {
        if (argumentsAreInvalid(mass, height)) {
            throwIllegalArgumentsException()
        }
        return mass / height.pow(2) * 703
    }
}