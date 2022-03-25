package com.example.in2000_oblig1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val brukerInput = findViewById<EditText>(R.id.inputFraBruker)
        val checkOrd = findViewById<Button>(R.id.konvert)
        val visResultat = findViewById<TextView>(R.id.visSvar)
        val neste = findViewById<Button>(R.id.button2)
        checkOrd.setOnClickListener {
            val tekst = brukerInput.text.toString()
            if (tekst == tekst.reversed()){
                visResultat.text = "$tekst er et plandrom"
            }else{
                visResultat.text = "$tekst er ikke et plandrom"
            }
            brukerInput.setText("")
            checkOrd.onEditorAction(EditorInfo.IME_ACTION_DONE)
        }

        neste.setOnClickListener {
            val intent = Intent(this, ConverterActivity::class.java)
            startActivity(intent)

        }



    }

}