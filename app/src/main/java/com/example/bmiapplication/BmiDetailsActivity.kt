package com.example.bmiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.bmiapplication.logic.BMICategory

class BmiDetailsActivity : AppCompatActivity() {
    private lateinit var bmiValueTextView: TextView
    private lateinit var bmiCategoryTextView: TextView

    private var bmiValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_details)

        bmiValueTextView = findViewById(R.id.BMIValueDetailsTextView)
        bmiCategoryTextView = findViewById(R.id.BMICategoryDetailsTextView)

        val bundle: Bundle? = intent.extras
        bmiValue = bundle!!.getDouble("bmiValue")
    }

    override fun onStart() {
        super.onStart()

        bmiValueTextView.text = String.format(getString(R.string.value_format), bmiValue)

        val category: BMICategory = BMICategory.from(bmiValue)

        setBmiValueTextViewColor(category)
        setCategoryDescription(category)
    }

    private fun setBmiValueTextViewColor(category: BMICategory) {
        when (category) {
            BMICategory.VERY_SEVERELY_UNDERWEIGHT -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.verySeverelyUnderweightBMI
                )
            )
            BMICategory.SEVERELY_UNDERWEIGHT -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.severelyUnderweightBMI
                )
            )
            BMICategory.UNDERWEIGHT -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.underweightBMI
                )
            )
            BMICategory.NORMAL -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.normalBMI
                )
            )
            BMICategory.OVERWEIGHT -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.overweightBMI
                )
            )
            BMICategory.OBESE_CLASS_1 -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.obeseClass1BMI
                )
            )
            BMICategory.OBESE_CLASS_2 -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.obeseClass2BMI
                )
            )
            BMICategory.OBESE_CLASS_3 -> bmiValueTextView.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.obeseClass3BMI
                )
            )
            else -> Log.w("BMI_CATEGORY", "Unknown BMI category")
        }
    }


    private fun setCategoryDescription(category: BMICategory) {
        when (category) {
            BMICategory.VERY_SEVERELY_UNDERWEIGHT -> bmiCategoryTextView.text =
                BMICategory.VERY_SEVERELY_UNDERWEIGHT.toString()
            BMICategory.SEVERELY_UNDERWEIGHT -> bmiCategoryTextView.text =
                BMICategory.SEVERELY_UNDERWEIGHT.toString()
            BMICategory.UNDERWEIGHT -> bmiCategoryTextView.text =
                BMICategory.UNDERWEIGHT.toString()
            BMICategory.NORMAL -> bmiCategoryTextView.text =
                BMICategory.NORMAL.toString()
            BMICategory.OVERWEIGHT -> bmiCategoryTextView.text =
                BMICategory.OVERWEIGHT.toString()
            BMICategory.OBESE_CLASS_1 -> bmiCategoryTextView.text =
                BMICategory.OBESE_CLASS_1.toString()
            BMICategory.OBESE_CLASS_2 -> bmiCategoryTextView.text =
                BMICategory.OBESE_CLASS_2.toString()
            BMICategory.OBESE_CLASS_3 -> bmiCategoryTextView.text =
                BMICategory.OBESE_CLASS_3.toString()
            else -> Log.w("BMI_CATEGORY", "Unknown BMI category")
        }
    }
}
