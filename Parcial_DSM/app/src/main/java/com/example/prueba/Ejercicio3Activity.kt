package com.example.prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class Ejercicio3Activity: AppCompatActivity(){
    lateinit var radioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio3)
        val n1=findViewById<EditText>(R.id.txtnum1)
        val n2=findViewById<EditText>(R.id.txtnum2)
        val resp=findViewById<TextView>(R.id.txtresp)
        val rg1=findViewById<RadioGroup>(R.id.RG)
        val btn1=findViewById<Button>(R.id.btnOpe)
        val btn2=findViewById<Button>(R.id.btnBorr)
        val rb1=findViewById<RadioButton>(R.id.rbsum)
        val rb2=findViewById<RadioButton>(R.id.rbres)
        val rb3=findViewById<RadioButton>(R.id.rbmult)
        val rb4=findViewById<RadioButton>(R.id.rbdiv)
        val num1=(n1).toString().toInt()
        val num2=(n2).toString().toInt()

        fun sum(){
            val tot=num1+num2
                resp.text = "Resultado: ${tot.toString()}"
        }
        fun res(){
            val tot=num1-num2
            resp.text = "Resultado: ${tot.toString()}"
        }
        fun mult(){
            val tot=num1*num2
            resp.text = "Resultado: ${tot.toString()}"
        }
        fun div(){
            val tot=num1/num2
            resp.text = "Resultado: ${tot.toString()}"
        }
            btn1.setOnClickListener {
                val selectedOption: Int = rg1!!.checkedRadioButtonId
                radioButton=findViewById(selectedOption)
                when (radioButton) {
                    rb1 -> {sum()
                    }
                    rb2 -> {res()}
                    rb3 -> {mult()}
                    rb4 -> {div()}
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