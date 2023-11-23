package com.john.proyectojohnpmdm2023_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.john.proyectojohnpmdm2023_2024.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {
    private lateinit var principalBinding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        principalBinding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(principalBinding.root)

        initHander()
        login()
    }

    private fun initHander() {
        var handler = Handler(Looper.getMainLooper()) //queremos que el tema de la IU, la llevemos al hilo principal.
        principalBinding.progressCircular.visibility = View.VISIBLE  //hacemos visible el progress
        principalBinding.cardview.visibility =   View.GONE //ocultamos el cardview.
        Thread{
            Thread.sleep( 2000)
            handler.post{
                principalBinding.progressCircular.visibility = View.GONE //ocultamos el progress

                principalBinding.cardview.visibility = View.VISIBLE
                Toast.makeText(this, "EStamos en la pantalla principal",
                    Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
    private fun login() {
        val txtName = principalBinding.textnombre
        val name = getIntent().getStringExtra("name")
        if (name!= null){
            txtName.text = "$name"
        }
    }
}