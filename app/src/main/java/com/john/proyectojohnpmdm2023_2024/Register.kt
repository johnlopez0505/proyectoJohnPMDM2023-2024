package com.john.proyectojohnpmdm2023_2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.john.proyectojohnpmdm2023_2024.databinding.ActivityLoginBinding
import com.john.proyectojohnpmdm2023_2024.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        initEvents()
    }

    private fun initEvents() {
        registerBinding.buttonSignUp.setOnClickListener{
            comprobarEstado()
        }
        registerBinding.buttonRegresarLogin.setOnClickListener{
            regresarLogin()
        }

    }


    fun comprobarEstado() {
        val name = registerBinding.editTextUsername.text.toString()
        val email = registerBinding.editTextEmail.text.toString()
        val password = registerBinding.editTextPassword.text.toString()
        val confirmPassword = registerBinding.editTextTextPassword2.text.toString()
        // Verificar que ningún campo esté vacío
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            // Mostrar un mensaje de error si algún campo está vacío
            val campo = "Campo no puede estar vacio"
            if(name.isEmpty())
                registerBinding.editTextUsername.error = campo
            if(email.isEmpty())
                registerBinding.editTextEmail.error = campo
            if (password.isEmpty())
                registerBinding.editTextPassword.error = campo
            if (confirmPassword.isEmpty())
                registerBinding.editTextTextPassword2.error = campo
            Toast.makeText(
                this, "Todos los campos deben ser completados",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (password == confirmPassword) {
            // Contraseña y confirmación coinciden, realiza el registro
            val usuario = Usuario(name, email, password)
            Usuarios.listaUsuarios.add(usuario)
            // Guarda la lista actualizada en el objeto Usuarios
            Usuarios.listaUsuarios = Usuarios.listaUsuarios
            Toast.makeText(
                this, "Usuario creado correctamente",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        } else {
            // Contraseña y confirmación no coinciden, muestra un mensaje de error
            registerBinding.editTextPassword.error = "Las contraseñas no coinciden"
            registerBinding.editTextTextPassword2.error = "Las contraseñas no coinciden"
            Toast.makeText(
                this, "las contraseñas no coinciden",
                Toast.LENGTH_SHORT
            ).show()

            return
        }
    }

    private fun regresarLogin() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

}