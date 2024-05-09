package com.example.costamaktywnosc

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity

const val start: Int = 0
const val end: Int = 20
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val wynikList = ArrayList<String>() // Lista na wyniki
        val adapterListView1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, wynikList)
        val listViewToUpdate = findViewById<ListView>(R.id.listaPubow)
        listViewToUpdate.adapter = adapterListView1
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //write custom code to on start progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        val btnSzukaj = findViewById<Button>(R.id.szukajButton)

        btnSzukaj.setOnClickListener {
            val wynik = StringBuilder()
            val pilka = findViewById<CheckBox>(R.id.pilka)
            val tenis = findViewById<CheckBox>(R.id.tenis)
            val zuzel = findViewById<CheckBox>(R.id.zuzel)
            wynikList.clear()

            if (seekBar.progress == 0) {
                wynik.append("Brak Barów w twojej odległości")
            } else {
                when (seekBar.progress) {
                    1 -> {
                        if (pilka.isChecked)
                            wynikList.addAll(pub5pilka)
                        if (tenis.isChecked)
                            wynikList.addAll(pub5tenis)
                    }
                    2 -> {
                        if (pilka.isChecked)
                            wynikList.addAll(pub10pilka)
                        if (tenis.isChecked)
                            wynikList.addAll(pub10tenis)
                        if (zuzel.isChecked)
                            wynikList.addAll(pub10zuzel)
                    }
                    3 -> {
                        if (pilka.isChecked)
                            wynikList.addAll(pub15pilka)
                        if (tenis.isChecked)
                            wynikList.addAll(pub15tenis)
                        if (zuzel.isChecked)
                            wynikList.addAll(pub15zuzel)
                        if (pilka.isChecked && tenis.isChecked && zuzel.isChecked)
                            wynik.append("pub ekstraGame - mecze piłkarskie, mecze tenisa, zawody żużlowe")
                    }
                    4 -> {
                        if (pilka.isChecked)
                            wynikList.addAll(pub20pilka)
                        if (tenis.isChecked)
                            wynikList.addAll(pub20tenis)
                        if (zuzel.isChecked)
                            wynikList.addAll(pub20zuzel)
                        if (pilka.isChecked && tenis.isChecked && zuzel.isChecked)
                            wynik.append("pub ekstraGame - mecze piłkarskie, mecze tenisa, zawody żużlowe")
                    }
                }
            }

            wynikList.add(wynik.toString())
            // Powiadom adapter o zmianie danych
            adapterListView1.notifyDataSetChanged()
        }

    }
}