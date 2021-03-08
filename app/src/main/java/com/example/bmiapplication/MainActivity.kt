package com.example.bmiapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.bmiapplication.logic.BMI
import com.example.bmiapplication.logic.BMICategory
import com.example.bmiapplication.logic.ImperialBMI
import com.example.bmiapplication.logic.MetricBMI
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var countButton: Button
    private lateinit var bmiValueTextView: TextView
    private lateinit var massEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var massTextView: TextView
    private lateinit var heightTextView: TextView

    private var bmi: BMI = MetricBMI()
    private var bmiValue: Double = 0.0

    private val BMI_DETAILS_ACTIVITY_REQUEST_CODE = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countButton = findViewById(R.id.countButton)
        bmiValueTextView = findViewById(R.id.BMIValueTextView)
        massEditText = findViewById(R.id.massEditText)
        heightEditText = findViewById(R.id.heightEditText)
        massTextView = findViewById(R.id.massTextView)
        heightTextView = findViewById(R.id.heightTextView)
    }

    override fun onStart() {
        super.onStart()

        countButton.setOnClickListener {
            try {
                val massVal = massEditText.text.toString().toDouble()
                val heightVal = heightEditText.text.toString().toDouble()

                bmiValue = bmi.value(massVal, heightVal)

                setBmiValueTextView()
            } catch (e: Exception) {
                when (e) {
                    is IllegalArgumentException -> bmiValueTextView.text =
                        getString(R.string.illegal_argument)
                    is NumberFormatException -> bmiValueTextView.text =
                        getString(R.string.illegal_argument)
                    else -> throw e
                }

            }
        }

        bmiValueTextView.setOnClickListener {
            val intent = Intent(this, BmiDetailsActivity::class.java)
            intent.putExtra("bmiValue", bmiValue)
            startActivityForResult(intent, BMI_DETAILS_ACTIVITY_REQUEST_CODE)

        }
    }

    private fun setBmiValueTextView() {
        bmiValueTextView.text = String.format(getString(R.string.value_format), bmiValue)

        setColorBmiValueTextView(bmiValue)


    }

    private fun setColorBmiValueTextView(bmiValue: Double) {
        when (BMICategory.from(bmiValue)) {
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.metric_item -> {
                setToMetric()
                true
            }
            R.id.imperial_item -> {
                setToImperial()
                true
            }
            R.id.author_item -> {
                startAuthorInfoActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setToMetric() {
        bmi = MetricBMI()
        massTextView.text = getString(R.string.mass_kg)
        heightTextView.text = getString(R.string.height_cm)
    }

    private fun setToImperial() {
        bmi = ImperialBMI()
        massTextView.text = getString(R.string.mass_lb)
        heightTextView.text = getString(R.string.height_in)
    }

    private fun startAuthorInfoActivity() {
        val intent = Intent(this, AuthorActivity::class.java)
        startActivity(intent)
    }
}