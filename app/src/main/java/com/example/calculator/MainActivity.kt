package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var num1: Double = 0.0
    private var operation: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        // DEL button
        findViewById<TextView>(R.id.delete).setOnClickListener {
            resultTextView.text = ""
        }

        // +/- button
        findViewById<TextView>(R.id.reverse).setOnClickListener {
            var t = resultTextView.text.toString()
            var number: Double = 0.0

            if (!TextUtils.isEmpty(t)){
                number = resultTextView.text.toString().toDouble()

            }
            resultTextView.text = (number * -1).toString()
        }

    }


    fun nClick(view: View) {

        if(view is TextView) {

            var  result: String = resultTextView.text.toString()
            val input: String = view.text.toString()

            if(result == "0") {
                result = ""
            }

            resultTextView.text = result + input

        }

    }


    fun operationClick(view: View) {

        if(view is TextView){

            if (!TextUtils.isEmpty(resultTextView.text)) {
                num1 = resultTextView.text.toString().toDouble()
            }

            operation = view.text.toString()
            resultTextView.text = ""
        }

    }

    fun equalsClick(view: View) {

        var num2Text = resultTextView.text.toString()
        var num2: Double = 0.0

        if(!TextUtils.isEmpty(num2Text)) {

            num2 = num2Text.toDouble()

        }

        when (operation) {
            "+" -> resultTextView.text = (num1 + num2).toString()
            "-" -> resultTextView.text = (num1 - num2).toString()
            "*" -> resultTextView.text = (num1 * num2).toString()
            "/" -> resultTextView.text = (num1 / num2).toString()
            "+/-" -> resultTextView.text = (num1 * -1).toString()
        }

    }


}




