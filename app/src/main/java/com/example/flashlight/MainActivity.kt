package com.example.flashlight

import android.annotation.SuppressLint
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var cameraManager : CameraManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        button = findViewById(R.id.bt)
        //val txt = button.text.toString()
    }

    fun change(view: View) {
        val txt = button.text.toString()
        if (txt == "ON")
        {
            button.text = "OFF"
            cameraManager.setTorchMode(cameraManager.cameraIdList[0], true)
            Toast.makeText(this,"Flashlight turned on",Toast.LENGTH_SHORT).show()
        }
        else
        {
            button.text = "ON"
            cameraManager.setTorchMode(cameraManager.cameraIdList[0], false)
            Toast.makeText(this,"Flashlight turned off",Toast.LENGTH_SHORT).show()
        }

    }


}