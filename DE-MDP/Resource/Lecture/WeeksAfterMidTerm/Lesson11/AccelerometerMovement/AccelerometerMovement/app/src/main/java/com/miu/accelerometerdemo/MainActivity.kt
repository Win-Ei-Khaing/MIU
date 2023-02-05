package com.miu.accelerometerdemo

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit  var sensor:Sensor
    //help us manage sensor components
    private lateinit var sm: SensorManager
    private lateinit var mPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sm = getSystemService(SENSOR_SERVICE) as SensorManager
        //select the sensor we wish to use
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        // Set the data source for the media player object
        mPlayer = MediaPlayer.create(this, R.raw.iphone)
    }
    // Register your Sensor Manager
    override fun onResume() {
        super.onResume()
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    // Unregister your Sensor Manager
    override fun onPause() {
        super.onPause()
        sm.unregisterListener(this)
    }
    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) display_reading.text =
                "X=${event.values[0]}\nY=${event.values[1]}\nZ=${event.values[2]}"
        if (event!!.values[0] > 10) {
            mPlayer.start()
        }
        // To release the media player once player complete the audio
        mPlayer.setOnCompletionListener(MediaPlayer.OnCompletionListener { mPlayer.release() })
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}