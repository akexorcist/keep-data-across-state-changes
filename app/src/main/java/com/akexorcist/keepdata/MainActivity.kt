package com.akexorcist.keepdata

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.keepdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val KEY_NAME = "key_name"
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var handleStateName: String? = null
    private var regularName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener { onSaveButtonClick() }
        binding.buttonShow.setOnClickListener { onShowButtonClick() }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        handleStateName = savedInstanceState.getString(KEY_NAME)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NAME, handleStateName)
    }

    private fun onSaveButtonClick() {
        val dummyName = "Akexorcist"
        SingletonCurrentUser.name = dummyName
        StaticCurrentUser.name = dummyName
        regularName = dummyName
        handleStateName = dummyName
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
    }

    private fun onShowButtonClick() {
        val message = """
            Singleton Name : ${SingletonCurrentUser.name}
            Static Name : ${StaticCurrentUser.name}
            Regular Name : $regularName
            Handle State Name : $handleStateName
            """.trimIndent()
        AlertDialog.Builder(this)
            .setTitle("Result")
            .setMessage(message)
            .setCancelable(true)
            .create()
            .show()
    }
}
