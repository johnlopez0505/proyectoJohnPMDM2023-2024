package com.john.proyectojohnpmdm2023_2024


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.john.proyectojohnpmdm2023_2024.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    val MYTAG = "LOGCAT"
    private lateinit var loginBinding : ActivityLoginBinding
    /*companion object{
        const val MYUSER = "john" // tu usuario
        const val MYPASS = "1234" // tu contraseña
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        initEvents()
        Log.i(MYTAG,"que pasa")
    }

    private fun initEvents() {
        loginBinding.buttonLogin.setOnClickListener {
            validarCredenciales()
        }

        loginBinding.buttonRegistrar.setOnClickListener{
            registerUser()
        }

    }

    private fun validarCredenciales() {
        val user = loginBinding.editTextUsername.text.toString()
        val password = loginBinding.editTextPassword.text.toString()
        val usuarioEncontrado = Usuarios.listaUsuarios.find { it.name==user && it.password ==password }

        if (usuarioEncontrado != null) {
            // El usuario ha iniciado sesión con éxito
            // Credenciales válidas, iniciar Activity principal
            val intent = Intent(this, Principal::class.java)
            intent.putExtra("name", user)  // Pasa el usuario como argumento al Activity principal
            startActivity(intent)
        } else {
            // Las credenciales no son válidas
            Toast.makeText(this, "Credenciales no válidas", Toast.LENGTH_SHORT).show()
        }
        /*
        if (user == MYUSER && password == MYPASS) {
            // Credenciales válidas, iniciar Activity principal
            val intent = Intent(this, Principal::class.java)
            intent.putExtra("usuario", user)  // Pasa el usuario como argumento al Activity principal
            startActivity(intent)

        } else {
            // Credenciales no válidas, mostrar Toast
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()

        }*/
    }
    private fun registerUser() {
        Log.i(MYTAG,"Entramos a registrar usuario")
        val  intent = Intent(this,Register::class.java)
        startActivity(intent)

    }
}
