package com.example.e_book

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var headingTV: TextView
    private lateinit var downloadBTN: Button
    private lateinit var textTV: TextView
    private lateinit var database: Database

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        headingTV = findViewById(R.id.headingTV)
        downloadBTN = findViewById(R.id.downloadBTN)
        textTV = findViewById(R.id.textTV)
        database = Database()
        downloadBTN.setOnClickListener {
            val book = loadBook(database.text)
            if (book.isNotEmpty()) {
                textTV.text = book.joinToString("\n")
            } else {
                textTV.text = "Книга пуста"
            }
        }
    }

    fun loadBook(text: String): List<String> {
        return text.split(" ") }
}