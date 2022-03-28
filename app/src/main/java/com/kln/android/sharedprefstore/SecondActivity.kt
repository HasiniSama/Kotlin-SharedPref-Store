package com.kln.android.sharedprefstore

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kln.android.sharedprefstore.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

        val name = preferences.getString("NAME", "")
        binding.textviewName.text = name
        val email = preferences.getString("EMAIL", "")
        binding.textviewEmail.text = email

        binding.btnLogout.setOnClickListener(){

            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}