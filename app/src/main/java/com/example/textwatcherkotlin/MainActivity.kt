package com.example.textwatcherkotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            textView.text = editText.text

        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (editText.length() >= 3) {
                    textView.setTextColor(Color.BLUE)
                    button.isEnabled = true

                    if (editText.length() >= 10) {
                        textView.setTextColor(Color.GREEN)
                    }

                } else {
                    button.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                textView.text = s

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textView.text = s
                editText.text!!.toString().trim { it <= ' ' }
                textView.text = " "

            }

        })

    }


}



