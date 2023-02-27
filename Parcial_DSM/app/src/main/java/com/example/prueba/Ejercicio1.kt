package com.example.prueba

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class Ejercicio1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio1)

        val nombre = findViewById<EditText>(R.id.nombre)
        val nota1 = findViewById<EditText>(R.id.nota1)
        val nota2 = findViewById<EditText>(R.id.nota2)
        val nota3 = findViewById<EditText>(R.id.nota3)
        val nota4 = findViewById<EditText>(R.id.nota4)
        val nota5 = findViewById<EditText>(R.id.nota5)

        val resultado = findViewById<TextView>(R.id.result)
        val calcular = findViewById<Button>(R.id.calcular)
        val promedio = findViewById<TextView>(R.id.promedio)
        val estado = findViewById<TextView>(R.id.estado)

        resultado.isVisible = false
        promedio.isVisible = false


        var prom: Float

        calcular.setOnClickListener{
            if(nota1.text.toString().toFloat() > 10 || nota2.text.toString().toFloat() > 10 || nota3.text.toString().toFloat() > 10 || nota4.text.toString().toFloat() > 10)
            {
                Toast.makeText(this, "Las calificaciones solo pueden ser del 0 al 10", Toast.LENGTH_LONG).show()
            }
            else{
                if(nota1.text.isNotEmpty() && nota2.text.isNotEmpty() && nota3.text.isNotEmpty() && nota4.text.isNotEmpty() && nota5.text.isNotEmpty()){
                    prom = (nota1.text.toString().toFloat() + nota2.text.toString().toFloat() + nota3.text.toString().toFloat() + nota4.text.toString().toFloat() + nota5.text.toString().toFloat())/5
                    if(prom >= 6.0){
                        resultado.text = nombre.text.toString() + " su promedio es:"
                        promedio.text = prom.toString()
                        Toast.makeText(this,"El promedio es:"+prom,Toast.LENGTH_SHORT).show()
                        estado.text = "APROBADO"
                        estado.setTextColor(resources.getColor(R.color.green))
                    }
                    else{
                        resultado.text = nombre.text.toString() + " su promedio es:"
                        promedio.text = prom.toString()
                        estado.text = "REPROBADO"
                        estado.setTextColor(resources.getColor(R.color.red))
                    }
                    resultado.isVisible = true
                    promedio.isVisible = true
                }
                else{
                    Toast.makeText(this, "Debe rellenar todos los campos para continuar", Toast.LENGTH_LONG).show()
                }
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