package com.example.encryptiondecryptiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EncryptedAppPreferences.init(applicationContext)

}

    override fun onResume() {
        super.onResume()
        EncryptedAppPreferences.mqtt = Mqtt(host = "test.com", "9866", "pokemon", "pikachu")

        Log.d(TAG, "onCreate: ${EncryptedAppPreferences.mqtt}")
    }

    companion object {
        const val TAG = "MainActivity"
    }


}