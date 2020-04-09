package com.mapelli.simone.edittextcostum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val m_cube_text = findViewById<TextView>(R.id.m_cube_text)
        m_cube_text.text = Html.fromHtml("m<sup>3</sup>")


        val sendBtn = findViewById<Button>(R.id.button)
        val leftInput = findViewById<EditText>(R.id.left)

        sendBtn.setOnClickListener {
            Toast.makeText(this@MainActivity, "Your text is ${leftInput.text}", Toast.LENGTH_SHORT).show()
        }

    }
}
