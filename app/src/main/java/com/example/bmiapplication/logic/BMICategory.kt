package com.example.bmiapplication.logic

enum class BMICategory {

    VERY_SEVERELY_UNDERWEIGHT {
        override fun toString(): String {
            return "Very severely underweight"
        }
    },

    SEVERELY_UNDERWEIGHT {
        override fun toString(): String {
            return "Severely underweight"
        }
    },

    UNDERWEIGHT {
        override fun toString(): String {
            return "Underweight"
        }
    },

    NORMAL {
        override fun toString(): String {
            return "Normal (healthy weight)"
        }
    },

    OVERWEIGHT {
        override fun toString(): String {
            return "Overweight"
        }
    },

    OBESE_CLASS_1 {
        override fun toString(): String {
            return "Obese Class I (Moderately obese)"
        }
    },

    OBESE_CLASS_2 {
        override fun toString(): String {
            return "Obese Class II (Severely obese)"
        }
    },

    OBESE_CLASS_3 {
        override fun toString(): String {
            return "Obese Class III (Very severely obese)"
        }
    },

    UNKNOWN {
        override fun toString(): String {
            return "Unknown"
        }
    };

    companion object {
        fun from(bmiValue: Double):BMICategory {
            when(bmiValue) {
                in Double.MIN_VALUE..15.0 -> return VERY_SEVERELY_UNDERWEIGHT
                in 15.0..16.0 -> return SEVERELY_UNDERWEIGHT
                in 16.0..18.5 -> return UNDERWEIGHT
                in 18.5..25.0 -> return NORMAL
                in 25.0..30.0 -> return OVERWEIGHT
                in 30.0..35.0 -> return OBESE_CLASS_1
                in 35.0..40.0 -> return OBESE_CLASS_2
                in 40.0..Double.MAX_VALUE -> return OBESE_CLASS_3
            }
            return UNKNOWN
        }
    }
}