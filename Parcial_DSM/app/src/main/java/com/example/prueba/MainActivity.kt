package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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