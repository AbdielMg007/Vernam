package com.example.vernam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buscador = findViewById<EditText>(R.id.buscador).text
        val llave = findViewById<EditText>(R.id.llave).text
        val btnEncriptar = findViewById<Button>(R.id.btn_encriptar)

        btnEncriptar.setOnClickListener {
            des_en(buscador.toString(), llave.toString())
        }
    }

    private fun des_en(buscador: String, llave: String){
        var tipoTitulo: String
        var tipoMensaje: String
        var pass: String

        if (buscador.isNotEmpty() && llave.isNotEmpty()) {
            val desencriptado = calcular(buscador, llave)
            pass = desencriptado()
            tipoTitulo = "Su codigo desencriptado es: "
            tipoMensaje = pass
            showMensaje(tipoTitulo, tipoMensaje)
        } else{
            tipoTitulo = "Error"
            tipoMensaje = "Porfavor, llene todos los campos"
            showMensaje(tipoTitulo, tipoMensaje)
        }
    }

    private fun showMensaje(titulo:String, mensaje: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}

