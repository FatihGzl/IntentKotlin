package com.example.intentkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentkotlin.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentFromMain = intent //getIntent()
        val name = intentFromMain.getStringExtra("name")
        val myInteger = intentFromMain.getIntExtra("myinteger", -1)
        println(myInteger)
        binding.nameText.text = "Name : ${name}"
    }

    fun previous(view : View) {
        val intent = Intent(this@NextActivity, MainActivity::class.java)
        startActivity(intent) // intent ile çağrılırsa bir aktivite onCreate çalıştırılır
        finish()
    }

}