package com.example.yuahang.mydemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv_text = findViewById(R.id.tv_text) as TextView
        tv_text.text="China sz"
        tv_text.setOnClickListener{
            Toast.makeText(this,"Hello Kotlin!",Toast.LENGTH_SHORT).show()
        }
    }
}
