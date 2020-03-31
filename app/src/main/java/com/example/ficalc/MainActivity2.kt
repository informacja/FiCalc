package com.example.ficalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    var input: TextView? = null
    var str: String? = null
    var operation:String? = null
    var a = 0.0
    var b:Double = 0.0
    var result:Double = 0.0
    var wasNoNmbr = true
    var wasNoResult:Boolean = true
    var bClear: Button? = null
    val fi:Double = 1.61803398875;
    var bChangeSign: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        input = findViewById(R.id.textView)
        str = ""
        bClear = findViewById(R.id.buttonAC)

//        bClear.setOnClickListener(View.OnClickListener() {
//            str = ""
//            input!!.text = "0"
//            operation = ""
//            result = 0.0
//            wasNoNmbr = true
//            wasNoResult = true
//        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("KEY", str)
        outState.putString("kOperation", operation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        str = savedInstanceState.getString("KEY","");
        operation = savedInstanceState.getString("kOperation","");
//        Toast.makeText(this, operation, Toast.LENGTH_LONG).show();
//        input?.setText(str);
        if (str != "") {
            a = str.toString().toDoubleOrNull()!!;
            wasNoNmbr = false;
        }
//        if (operation != "") {
//            input.setText(operation);
//        }
    }

    fun onClickNumber(view: View) {
        val bNmbr = view as Button
        if (wasNoNmbr) {
            str += bNmbr.text.toString()
            input!!.text = str
            a = str!!.toDouble()
            wasNoNmbr = false
        } else {
            str += bNmbr.text.toString()
            input!!.text = str
            b = str!!.toDouble()
            wasNoNmbr = true
        }
    }

    fun onClickOperation(view: View) {
        val bOperation = view as Button
        operation = bOperation.text.toString()
        input!!.text = operation
        str = ""
    }

    fun calculate(view: View?) {
        if (wasNoResult) {
            result = 0.0
            wasNoResult = false
        } else {
            a = result
            wasNoResult = true
        }
        when (operation) {
            "+" -> result = a + b
            "-" -> result = a - b
            "%" -> {
                a /= 100.0
                result = a * b
            }
            "/" ->
                if (b == 0.0 || b == 0.0) {
                    str = "Inf"
                } else {
                    result = a / b
                }
            "*" -> result = a * b
            "φ" -> a *= fi
            else -> str = "NaN"
        }
        if (str == "Inf") {
            input!!.text = str
        } else {
            str = result.toString()
            input!!.text = str
        }
//            Log.d("#########",str);
    }

    fun factorial(x: Double): Double {
        var res = 1.0
        var i = 1
        while (i <= x) {
            res *= i.toDouble()
            i++
        }
        return res
    }

}