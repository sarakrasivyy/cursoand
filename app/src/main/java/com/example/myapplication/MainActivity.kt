package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeechService
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {


    var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts= TextToSpeech(this, this)

      var message: String = findViewById<TextView>(R.id.textview).text.toString()
        Log.i("message TextView", message)
    }

    override fun onInit(status: Int) {
        if (status== TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.textview).text ="listo"
        }else {
            findViewById<TextView>(R.id.textview).text ="no permitido"

        }

    }

}