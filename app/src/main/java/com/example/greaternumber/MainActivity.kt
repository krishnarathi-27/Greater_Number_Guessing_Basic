package com.example.greaternumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*var btn : Button = findViewById(R.id.leftbtn)
        btn.setOnClickListener {

        }*/

        leftbtn.setOnClickListener{

           checkResult(true)

            assignNumberstoButtons()
        }

        rightbtn.setOnClickListener {

            checkResult(false)
            assignNumberstoButtons()
        }
    }

    private fun checkResult(isleftButtonSelected: Boolean)
    {
        val leftnum = leftbtn.text.toString().toInt()
        val rightnum = rightbtn.text.toString().toInt()

        val isAnswerCorrect = if(isleftButtonSelected)   leftnum > rightnum  else   rightnum > leftnum
        if(isAnswerCorrect)
        {
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
        }else{
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong!",Toast.LENGTH_SHORT).show()
        }
    }
    private fun assignNumberstoButtons() {
        val r = Random()
        val leftnum = r.nextInt(10)
        var rightnum = leftnum

        while(leftnum == rightnum)
        {
            rightnum = r.nextInt(10)
        }
        leftbtn.text = leftnum.toString()
        rightbtn.text = rightnum.toString()
    }
}