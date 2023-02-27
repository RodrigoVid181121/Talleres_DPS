package com.example.prueba

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

import android.widget.TextView
import android.widget.EditText
import androidx.core.view.isVisible
import java.math.RoundingMode
import java.text.DecimalFormat

class Ejercicio2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio2)

        val nombre = findViewById<EditText>(R.id.name)
        val salario = findViewById<EditText>(R.id.sal)

        val isss = findViewById<TextView>(R.id.isss)
        val afp = findViewById<TextView>(R.id.afp)
        val renta = findViewById<TextView>(R.id.rent)

        val slneto = findViewById<TextView>(R.id.viewSal)
        val nombreView = findViewById<TextView>(R.id.viewname)
        val txtdesc = findViewById<TextView>(R.id.txtDesc)
        val tot_desc = findViewById<TextView>(R.id.tot_Desc)

        val calcular = findViewById<Button>(R.id.calcular)

        slneto.isVisible = false
        nombreView.isVisible = false
        tot_desc.isVisible = false
        txtdesc.isVisible = false

        var isssVal: Double
        var afpVal: Double
        var rentVal: Double
        var desc: Double
        var slnetoVal: Double

        val decimal = DecimalFormat("#.##")
        decimal.roundingMode = RoundingMode.DOWN

        calcular.setOnClickListener{
            if(nombre.text.toString().isNotEmpty() && salario.text.toString().isNotEmpty()){
                isssVal = salario.text.toString().toDouble() * 0.03
                afpVal = salario.text.toString().toDouble() * 0.04
                rentVal = salario.text.toString().toDouble() * 0.05

                desc = (isssVal + afpVal + rentVal)

                val saliente = decimal.format(desc)
                val isssR = decimal.format(isssVal)
                val afpR = decimal.format(afpVal)
                val rentaR = decimal.format(rentVal)

                isss.text = "$"+isssR.toString()
                afp.text = "$"+afpR.toString()
                renta.text = "$"+rentaR.toString()
                tot_desc.text = "$"+saliente.toString()

                slneto.isVisible = true
                nombreView.isVisible = true
                tot_desc.isVisible = true
                txtdesc.isVisible = true

                nombreView.text = nombre.text.toString() + " su suelo neto es de:"
                slnetoVal = (salario.text.toString().toDouble() - saliente.toString().toDouble())

                var slnetoR = decimal.format(slnetoVal)

                slneto.text = "$"+ slnetoR.toString()

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Ejercicio1 -> Ej1()
            R.id.Ejercicio2 -> Ej2()
            R.id.Ejercicio3 -> Ej3()
        }

        return super.onOptionsItemSelected(item)
    }

    fun Ej1(){
        val ejercicio1 = Intent(this, Ejercicio1::class.java)
        startActivity(ejercicio1)
    }
    fun Ej2(){
        val ejercicio1 = Intent(this, Ejercicio2::class.java)
        startActivity(ejercicio1)
    }
    fun Ej3(){
        val ejercicio1 = Intent(this, Ejercicio3Activity::class.java)
        startActivity(ejercicio1)
    }
}