package com.example.demo_activityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object{
        private const val  FIRST_ACTIVITY_REQUEST_CODE = 1
    }

    lateinit var btn_launch_activity_first: Button
    lateinit var btn_launch_activity_second: Button
    lateinit var tv_first_activity_result: TextView
    lateinit var tv_second_activity_result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_launch_activity_first = findViewById(R.id.btn_launch_activity_first)
        btn_launch_activity_second = findViewById(R.id.btn_launch_activity_second)
        tv_first_activity_result = findViewById(R.id.tv_first_activity_result)
        tv_second_activity_result = findViewById(R.id.tv_second_activity_result)

        btn_launch_activity_first.setOnClickListener{
            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == FIRST_ACTIVITY_REQUEST_CODE){
                tv_first_activity_result.text = "First Activity Result Success"
            }
        }else if(resultCode == Activity.RESULT_CANCELED){
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this,"Result Cancelled",Toast.LENGTH_SHORT).show()
        }
    }

}