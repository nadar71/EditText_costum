package com.mapelli.simone.edittextcostum

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
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
    // lateinit var checkInput: TextView


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

        // leftInput.setText("TEST")
        // checkInput = findViewById(R.id.check_typing_tv)

        // hide status bar
        if (Build.VERSION.SDK_INT < 24) {
            m_cube_text.text = Html.fromHtml("m<sup>3</sup>")
        } else if (Build.VERSION.SDK_INT >= 24) {
            m_cube_text.text = Html.fromHtml("m<sup>3</sup>",Html.FROM_HTML_MODE_LEGACY)
        }



        left_edit.addTextChangedListener(object: TextWatcher
        {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // nothing
            }

            override fun afterTextChanged(p0: Editable?) {
                var currentText = StringBuilder()

                if (!left_edit.text.toString().equals(".")) {
                    currentText = StringBuilder(left_text.text.toString().drop(1))

                    Log.d(TAG, "DEBUG : current text except first : " + currentText)
                    val input = left_edit.text.toString()
                    left_edit.text.clear()

                    Log.d(TAG, "DEBUG : current text with new appended : " + currentText.append(input))
                    left_text.setText(currentText.append(input))
                } else {
                    currentText = StringBuilder(left_text.text.toString())
                    left_edit.text.clear()
                    left_text.setText(currentText)
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // nothing
            }
        })



        send_btn.setOnClickListener {
            Toast.makeText(this@MainActivity, "Your text is ${left_text.text}", Toast.LENGTH_SHORT).show()
        }

    }

/*
    override fun onKeyDown( keyCode : Int,  event: KeyEvent) : Boolean  {
        Log.d(TAG, "key downed : " + keyCode);
        if ( keyCode == KeyEvent.KEYCODE_1 /* HERE AN OBSVIOUSLY FALSE CONSTANT*/ ) {

            // perform your desired action here
            leftInput.setText("1")
            // return 'true' to prevent further propagation of the key event
            return true;
        }

        // let the system handle all other key events
        return super.onKeyDown(keyCode, event);
    }
 */
}
