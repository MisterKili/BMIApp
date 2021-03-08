package com.example.bmiapplication.logic

import junit.framework.TestCase
import org.junit.Test
import kotlin.math.roundToLong

class ImperialBMITest : TestCase() {

    private val imperialBMI = ImperialBMI()

    @Test
    fun testMetricBMIProperValue() {
        val valueBMI = (imperialBMI.value(165.0, 71.0) * 10.0).roundToLong() / 10.0
        val valueBMIFromAnotherCalculator = 23.0

        assertEquals(valueBMIFromAnotherCalculator, valueBMI)
    }

    @Test
    fun testMetricBMIProperDecimalValue() {
        val valueBMI = (imperialBMI.value(165.35, 70.87) * 10.0).roundToLong() / 10.0
        val valueBMIFromAnotherCalculator = 23.1

        assertEquals(valueBMIFromAnotherCalculator, valueBMI)
    }

    @Test
    fun testMetricBMIValueMass0Height0() {
        var exception: IllegalArgumentException? = null

        try {
            imperialBMI.value(0.0, 0.0)
        } catch (e: IllegalArgumentException) {
            exception = e
        }

        assertNotNull(exception)
        if (exception != null) {
            exception.message?.let { assert(it.contains("Mass and height must be greater than 0")) }
        }
    }
}