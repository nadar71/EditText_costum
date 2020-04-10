package com.mapelli.simone.edittextcostum

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var left_edit: EditText
    lateinit var send_btn: Button
    lateinit var m_cube_text: TextView
    lateinit var left_text: TextView

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    @SuppressWarnings("deprecation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        m_cube_text = findViewById(R.id.m_cube_text)
        left_text   = findViewById(R.id.left)
        left_edit   = findViewById(R.id.left_edittext)
        send_btn    = findViewById(R.id.button)


        if (Build.VERSION.SDK_INT < 24) {
            m_cube_text.text = Html.fromHtml("m<sup>3</sup>")
        } else if (Build.VERSION.SDK_INT >= 24) {
            m_cube_text.text = Html.fromHtml("m<sup>3</sup>",Html.FROM_HTML_MODE_LEGACY)
        }



        left_edit.addTextChangedListener(object: TextWatcher
        {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val currentText : StringBuilder
                when(left_edit.text.toString()){
                    ".","-","," -> { // filter excluded chars
                        currentText = StringBuilder(left_text.text.toString())
                        left_edit.text.clear()
                        left_text.setText(currentText)
                    }
                    else -> {
                        currentText = StringBuilder(left_text.text.toString().drop(1))
                        val input = left_edit.text.toString()
                        left_edit.text.clear()
                        left_text.setText(currentText.append(input))
                    }
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })


        send_btn.setOnClickListener {
            Toast.makeText(this@MainActivity, "Your text is ${left_text.text}",
                Toast.LENGTH_SHORT).show()
        }

    }


}
