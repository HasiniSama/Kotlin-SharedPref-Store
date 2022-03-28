package com.kln.android.sharedprefstore

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kln.android.sharedprefstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if(isRemembered){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener(){

            val name: String = binding.editName.text.toString()
            val email: String = binding.editEmail.text.toString()
            val checked: Boolean = binding.checkRemember.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putString("EMAIL",email)
            editor.putBoolean("CHECKBOX", checked)
            editor.apply()

            Toast.makeText(this,"User Saved", Toast.LENGTH_LONG).show()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}