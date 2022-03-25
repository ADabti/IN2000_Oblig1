package com.example.in2000_oblig1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

class ConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val nesteActivity = findViewById<Button>(R.id.neste)

        ArrayAdapter.createFromResource(this, R.array.verdier, android.R.layout.simple_spinner_item). also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                displayNumber(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ConverterActivity, "Skriv et gyldig nummer!", Toast.LENGTH_SHORT).show()

            }
        }

        nesteActivity.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)

        }


    }
    @SuppressLint("SetTextI18n")
    fun displayNumber(position: Int){
        val verdier = resources.getStringArray(R.array.verdier)
        val tallFraBruker = findViewById<EditText>(R.id.tallFraBruker)
        val konvert = findViewById<Button>(R.id.konvert)

        konvert.setOnClickListener{


            if(tallFraBruker.text.isEmpty()){
                Toast.makeText(this@ConverterActivity, "Skriv et gyldig nummer!", Toast.LENGTH_SHORT).show()

            }
            if(tallFraBruker.text.isNotEmpty()){
                val visSvar = findViewById<TextView>(R.id.visSvar)
                val tall = tallFraBruker.text.toString().toDouble()
                if(verdier[position] == "fluid ounce"){
                    val svar = BigDecimal(tall * 0.02957).setScale(2, RoundingMode.HALF_EVEN)
                    visSvar.text = svar.toString()
                }

                if(verdier[position] == "cup"){
                    val svar = BigDecimal(tall * 0.23659).setScale(2, RoundingMode.HALF_EVEN)
                    visSvar.text = svar.toString()
                }

                if(verdier[position] == "gallon"){
                    val svar = BigDecimal(tall * 3.78541).setScale(2, RoundingMode.HALF_EVEN)
                    visSvar.text = svar.toString()
                }

                if(verdier[position] == "hogshead"){
                    val svar = BigDecimal(tall * 238.481).setScale(2, RoundingMode.HALF_EVEN)
                    visSvar.text = svar.toString()
                }
            }

            tallFraBruker.setText("")
            konvert.onEditorAction(EditorInfo.IME_ACTION_DONE)
        }


    }


}