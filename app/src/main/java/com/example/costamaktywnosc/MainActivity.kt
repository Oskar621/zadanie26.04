package com.example.costamaktywnosc

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val start: Int = 0
val end: Int = 20
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val puby0 = "Brak Barów w twojej odległości"
        val pub5pilka = arrayOf("pub superBowl - mecze piłkarskie","pub JackRussel - mecze piłkarskie")
        val pub5tenis = arrayOf("pub SuperRakieta - mecze tenisa")
        val pub10pilka = arrayOf("Pub superBowl - mecze piłkarskie", "pub JackRussel - mecze piłkarskie", "pub footballGame - mecze piłkarskie")
        val pub10tenis = arrayOf("pub superRakieta - mecze tenisa","pub biforek - mecze tenisowe")
        val pub10zuzel = arrayOf("pub Racing - zawody żużlowe")
        val pub15pilka = arrayOf("pub superBowl - mecze piłkarskie", "pub JackRussel - mecze piłkarskie", "pub footballGame - mecze piłkarskie")
        val pub15tenis = arrayOf("pub superRakieta - mecze tenisa", "pub biforek - mecze tenisowe")
        val pub15zuzel = arrayOf("pub Racing - zawody żużlowe")
        val pub20pilka = arrayOf("pub superBowl - mecze piłkarskie", "pub JackRussel - mecze piłkarskie", "pub footballGame - mecze piłkarskie", "pub Wilki, mecze piłkarskie", "pub dzikie Koty, mecze piłkarskie")
        val pub20tenis = arrayOf("pub superRakieta - mecze tenisa","pub biforek - mecze tenisowe", "pub czarno na białym - mecze tenisa")
        val pub20zuzel = arrayOf("pub Racing - zawody żużlowe")

        val seekBar = findViewById<SeekBar>(R.id.ileKm)
        seekBar.max = end/5
        seekBar.min = start
        val adapterListView1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, puby0)
        val listViewToUpdate = findViewById<ListView>(R.id.listView)
        listViewToUpdate.adapter = adapterListView1
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                Toast.makeText(applicationContext, (seekBar.progress*5).toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //write custom code to on start progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        val btnSzukaj = findViewById<Button>(R.id.szukajButton)

        btnSzukaj.setOnClickListener {
            var wynik = ""
            val pilka = findViewById<CheckBox>(R.id.checkBox1)
            val tenis = findViewById<CheckBox>(R.id.checkBox2)
            val zuzel = findViewById<CheckBox>(R.id.checkBox3)
            if (seekBar.progress == 0)
                wynik = puby0

            else if(seekBar.progress == 5){
                if (pilka.isChecked)
                    wynik+= pub5pilka
                if (tenis.isChecked)
                    wynik+= pub5tenis
            }
            else if(seekBar.progress == 10){
                if (pilka.isChecked)
                    wynik+= pub10pilka
                if (tenis.isChecked)
                    wynik+= pub10tenis
                if (zuzel.isChecked)
                    wynik+= pub10zuzel
            }
            else if(seekBar.progress == 15) {
                if (pilka.isChecked)
                    wynik += pub15pilka
                if (tenis.isChecked)
                    wynik += pub15tenis
                if (zuzel.isChecked)
                    wynik += pub15zuzel
                if (pilka.isChecked && tenis.isChecked && zuzel.isChecked)
                    wynik += "pub ekstraGame - mecze piłkarskie, mecze tenisa, zawody żużlowe"
            }
            else if(seekBar.progress == 20){
                if (pilka.isChecked)
                    wynik+= pub20pilka
                if (tenis.isChecked)
                    wynik+= pub20tenis
                if (zuzel.isChecked)
                    wynik+= pub20zuzel
                if (pilka.isChecked && tenis.isChecked && zuzel.isChecked)
                    wynik += "pub ekstraGame - mecze piłkarskie, mecze tenisa, zawody żużlowe"
                }
        }

    }
}