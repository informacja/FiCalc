package com.example.ficalc

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.Nullable;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.Toast;

class MainActivity : AppCompatActivity() {
    var input: TextView? = null
    var str: String? = null
    var operation:String? = null
    var a = 0.0
    var b:Double = 0.0
    var result:Double = 0.0
    var wasNoNmbr = true
    var wasNoResult:Boolean = true
    var bClear: Button? = null
    var bChangeSign:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.ctivity_main)
//        input = findViewById(R.id.textView)
//        str = ""
//        bClear = findViewById(R.id.bClear)
//        bChangeSign = findViewById(R.id.bChangeSign)
//
//        this.bClear.setOnClickListener(View.OnClickListener {
//            str = ""
//            screen!!.text = "0"
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
//        screen?.setText(str);
        if (str != "") {
            a = str.toString().toDoubleOrNull()!!;
            wasNoNmbr = false;
        }
//        if (operation != "") {
//            screen.setText(operation);
//        }
    }

    fun onClickNumber(view: View) {
//        val bNmbr = view as Button
//        if (wasNoNmbr) {
//            str += bNmbr.text.toString()
//            screen!!.text = str
//            a = str!!.toDouble()
//            wasNoNmbr = false
//        } else {
//            str += bNmbr.text.toString()
//            screen!!.text = str
//            b = str!!.toDouble()
//            wasNoNmbr = true
//        }
    }

    fun onClickOperation(view: View) {
//        val bOperation = view as Button
//        operation = bOperation.text.toString()
//        screen!!.text = operation
//        str = ""
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
            "/" -> //                Log.d("#########",String.valueOf(b));
                if (b == 0.0 || b == 0.0) {
                    str = "Dla sfery ∞"
                } else {
                    result = a / b
                }
            "x" -> result = a * b
            "+/-" -> a *= -1.0
            "x!" -> result = factorial(a)
            "SQRT" -> //            Log.d("#########",String.valueOf(a));
                result = Math.sqrt(a)
            "x^3" -> result = Math.pow(a, 3.0)
            "x^2" -> result = Math.pow(a, 2.0)
            "log10" -> result = Math.log10(a)
            else -> str = "NaN"
        }
//        if (str == "Dla sfery ∞") {
////            Log.d("#########",str);
//            screen!!.text = str
//        } else {
////            Log.d("===================",str);
//            str = result.toString()
//            screen!!.text = str
//        }
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
