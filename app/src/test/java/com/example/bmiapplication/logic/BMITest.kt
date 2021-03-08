package com.example.bmiapplication.logic

import junit.framework.TestCase
import org.junit.Test
import kotlin.math.roundToLong

class BMITest : TestCase() {

    private val metricBMI = MetricBMI()

    @Test
    fun testMetricBMIProperValue() {
        val valueBMI = (metricBMI.value(75.0, 180.0) * 10.0).roundToLong() / 10.0
        val valueBMIFromAnotherCalculator = 23.1

        assertEquals(valueBMIFromAnotherCalculator, valueBMI)
    }

    @Test
    fun testMetricBMIProperDecimalValue() {
        val valueBMI = (metricBMI.value(75.5, 180.2) * 10.0).roundToLong() / 10.0
        val valueBMIFromAnotherCalculator = 23.3

        assertEquals(valueBMIFromAnotherCalculator, valueBMI)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testMetricBMIValueHeight0() {
        var exception: IllegalArgumentException? = null

        try {
            metricBMI.value(80.0, 0.0)
        } catch (e: IllegalArgumentException) {
            exception = e
        }

        assertNotNull(exception)
        if (exception != null) {
            exception.message?.let { assert(it.contains("Mass and height must be greater than 0")) }
        }
    }

    @Test
    fun testMetricBMIValueMass0() {
        var exception: IllegalArgumentException? = null

        try {
            metricBMI.value(80.0, 0.0)
        } catch (e: IllegalArgumentException) {
            exception = e
        }

        assertNotNull(exception)
        if (exception != null) {
            exception.message?.let { assert(it.contains("Mass and height must be greater than 0")) }
        }
    }

    @Test
    fun testMetricBMIValueMass0Height0() {
        var exception: IllegalArgumentException? = null

        try {
            metricBMI.value(0.0, 0.0)
        } catch (e: IllegalArgumentException) {
            exception = e
        }

        assertNotNull(exception)
        if (exception != null) {
            exception.message?.let { assert(it.contains("Mass and height must be greater than 0")) }
        }
    }
}