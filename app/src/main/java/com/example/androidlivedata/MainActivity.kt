package com.example.androidlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val textView: TextView
        get() = findViewById<TextView>(R.id.textView)

    private val button: Button
        get() = findViewById<Button>(R.id.button)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.factLiveData.observe(this, Observer{
            textView.text = it
        })

        button.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}