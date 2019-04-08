package com.zain.gditask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microblink.entities.recognizers.RecognizerBundle
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.content.pm.ActivityInfo
import com.microblink.util.RecognizerCompatibility
import com.microblink.util.RecognizerCompatibilityStatus


class MainActivity : AppCompatActivity() {
    private lateinit var mRecognizer: MrtdRecognizer
    private lateinit var mRecognizerBundle: RecognizerBundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        if (!supportBlinkId()) {
            return
        }
        mRecognizer = MrtdRecognizer()
        mRecognizerBundle = RecognizerBundle(mRecognizer)
        registeration.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }

    private fun supportBlinkId(): Boolean {
        val status =
            RecognizerCompatibility.getRecognizerCompatibilityStatus(this)
        if (status === RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is supported!", Toast.LENGTH_LONG).show()
            return true
        } else {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + status.name, Toast.LENGTH_LONG).show()
            return false
        }
    }
}
