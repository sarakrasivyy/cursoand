package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeechService
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        findViewById<Button>(R.id.btplay)!!.setOnClickListener{speak()}
    }

    private fun speak() {
        var message = findViewById<EditText>(R.id.etmensaje).text.toString()

        if (message.isEmpty()) {
            message = "¿Es en serio? Ya pon algo en el edit text"
        }
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
        /*if (!message.isEmpty()) {
            tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
        }*/
    }

    override fun onInit(status: Int) {

        // asignar variable en un if
       // findViewById<TextView>(R.id.txstatus).text = if (status==TextToSpeech.SUCCESS)
        if (status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.txstatus).text = "listo"
            tts!!.language = Locale("ES")

        } else {
            findViewById<TextView>(R.id.txstatus).text = "lno isto"
        }
    }

    override fun onDestroy() {
        if (tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }

        super.onDestroy()
    }
}