package com.example.intentkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        println("onCreate executed")

    }

    override fun onStart() {
        super.onStart()
        println("onStart executed")
        //binding.editText.setText("")
    }

    override fun onResume() {
        super.onResume()
        println("onResume executed")
    }

    override fun onPause() {
        super.onPause()
        println("onPause executed")
    }

    override fun onStop() {
        super.onStop()
        println("onStop executed")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy executed")
    }



    fun next(view : View) {
        val intent = Intent(this@MainActivity, NextActivity::class.java)
        intent.putExtra("name", binding.editText.text.toString())
        intent.putExtra("myinteger", 10)
        startActivity(intent)
        finish() // onDestroy çağır benim aktivitemi bitir kapat demek
    }
}