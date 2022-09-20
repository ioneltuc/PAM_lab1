package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StrictMath.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBMIButton.setOnClickListener{
            var reader = Reader()

            var userHeight: Double = reader.assignValue(textInputHeight.text.toString())
            var userWeight: Double = reader.assignValue(textInputWeight.text.toString())

            var calculator = BMICalculator(userHeight, userWeight)
            var outputBMI = calculator.calculateBMI()

            resultBMI.text = String.format("%.2f", outputBMI)
        }

    }
}

class BMICalculator constructor(userHeight: Double, userWeight: Double){
    private var height = 0.0
    private var weight = 0.0

    init{
        height = userHeight
        weight = userWeight
    }

    fun calculateBMI(): Double{
        return weight / pow((height / 100.0), 2.0)
    }
}

class Reader(){
    fun assignValue(input: String): Double{
        if(input?.length == 0) {
            return 0.0
        }

        return input.toDouble()
    }
}