package com.example.abdulrad_oblig

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)



        val santKnapp = findViewById<Button>(R.id.sant)
        val usantKnapp = findViewById<Button>(R.id.usant)
        val restart = findViewById<Button>(R.id.restart)
        val poengAnt = findViewById<TextView>(R.id.poeng)
        val spm = findViewById<TextView>(R.id.spm)

        val listAvSpm = mutableListOf<Quistion>()

        //starter a lage spm
        val spm1 = Quistion("Olympic Swimming Pool is 50 meters long", true)
        listAvSpm.add(spm1)
        val spm2 = Quistion("O represent Helium in The Periodic Table", false)
        listAvSpm.add(spm2)
        val spm3 = Quistion("Harald V is the King of Norway", true)
        listAvSpm.add(spm3)
        val spm4 = Quistion("  ", true)
        listAvSpm.add(spm4)


        var poeng = 0
        var counter = 0

        var spmnaa = listAvSpm[counter]

        var svar = listAvSpm[0].sant
        spm.text = spmnaa.spm

        santKnapp.setOnClickListener{




                if (spmnaa.sant) {
                    poeng++
                    counter++
                    spmnaa = listAvSpm[counter]
                    svar = spmnaa.sant
                    poengAnt.text = "Rikig! Du har $poeng poeng"
                    spm.text = spmnaa.spm
                    ferdig(counter, usantKnapp, santKnapp)

                } else {
                    counter++
                    spmnaa = listAvSpm[counter]
                    svar = spmnaa.sant
                    poengAnt.text = "Feil! Du har $poeng poeng"
                    spm.text = spmnaa.spm
                    ferdig(counter, usantKnapp, santKnapp)
                }

            }



        usantKnapp.setOnClickListener {




                if (!spmnaa.sant) {
                    poeng++
                    counter++
                    spmnaa = listAvSpm[counter]
                    svar = spmnaa.sant
                    poengAnt.text = "Riktig! Du har $poeng poeng"
                    spm.text = spmnaa.spm
                    ferdig(counter, usantKnapp, santKnapp)

                } else {
                    counter++
                    spmnaa = listAvSpm[counter]
                    svar = spmnaa.sant
                    poengAnt.text = "Feil! Du har $poeng poeng"
                    spm.text = spmnaa.spm
                    ferdig(counter, usantKnapp, santKnapp)
                }



        }
        restart.setOnClickListener{
            this.recreate()
        }

    }
    private fun ferdig(counter: Int, usant: Button, sant: Button){
        if(counter > 2){// siden jeg skal ha kun tre spm
            usant.isClickable = false
            usant.background.alpha = 64
            sant.isClickable = false
            sant.background.alpha = 64
            Toast.makeText(this@QuizActivity, "Quiz er ferdig!", Toast.LENGTH_SHORT).show()

        }

    }


}