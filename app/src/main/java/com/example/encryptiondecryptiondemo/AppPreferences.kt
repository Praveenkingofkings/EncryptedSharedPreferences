package com.example.encryptiondecryptiondemo

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.Gson

object EncryptedAppPreferences {

    private const val NAME = "sample_prefs"

    private lateinit var preferences: EncryptedSharedPreferences

    fun init(context: Context) {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
        preferences = EncryptedSharedPreferences.create(
            NAME,
            mainKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ) as EncryptedSharedPreferences
    }

    private val SAMPLE_TEXT = Pair("sample text", null)


    private inline fun EncryptedSharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    private var sampleText: String?
        get() {
            return preferences.getString(SAMPLE_TEXT.first, SAMPLE_TEXT.second)
        }
        set(value) {
            preferences.edit {
                it.putString(SAMPLE_TEXT.first, sampleText)
            }
        }

}