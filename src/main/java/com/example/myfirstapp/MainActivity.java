package com.example.myfirstapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";

    private SensorManager sensorManager;
    Sensor accelerometer;
    Sensor gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // logging
        Log.d(TAG, "onCreate: Initializing Sensor Services");
        // get the sensor manger
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        // Setting accelerometer
        // get the particular sensor
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // register listener
        sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        // logging
        Log.d(TAG, "onCreate: Register accelerometer listener");

        // Setting gyroscope
        // get the particular sensor
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        // register listener
        sensorManager.registerListener(MainActivity.this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        // logging
        Log.d(TAG, "onCreate: Register accelerometer listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            Log.d(TAG, "onSensorChanged ACCELEROMETER: X -> " + event.values[0] + ", Y -> " + event.values[1] +", Z -> " + event.values[2]);
        }

        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            Log.d(TAG, "onSensorChanged GYROSCOPE: X -> " + event.values[0] + ", Y -> " + event.values[1] +", Z -> " + event.values[2]);
        }
    }
}