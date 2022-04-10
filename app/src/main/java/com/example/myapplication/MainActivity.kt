package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import java.util.*

class MainActivity : AppCompatActivity() {
    var counter = -1
    val places = arrayOf<Array<String>>(listOf<String>("DODO", "Krasnodar").toTypedArray(),
                                        listOf<String>("PAPA DZONS", "Moscow").toTypedArray(),
                                        listOf<String>("Macdonals", "Not Russia").toTypedArray())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        change()
    }
    fun showHide(view:View) {
        view.visibility = if (view.visibility == View.VISIBLE){
            View.INVISIBLE
        } else{
            View.VISIBLE
        }
    }
    fun accept(view: View) {
        Toast.makeText(getApplicationContext(), "Заказ принят!", Toast.LENGTH_SHORT).show()
        showHide(findViewById<LinearLayout>(R.id.order))
        showHide(findViewById<LinearLayout>(R.id.linearLayout))
        showHide(findViewById<LinearLayout>(R.id.relativeLayout))
    }
    fun dismiss(view: View) {
        change()
    }
    fun change() {
        counter++
        if (counter < places.size) {
            findViewById<TextView>(R.id.name).setText(places[counter][0])
            findViewById<TextView>(R.id.place).setText(places[counter][1])
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val time = Random.nextInt(hour+1, 23).toString()+":"+Random.nextInt(10, 59).toString()
            findViewById<TextView>(R.id.date).setText(time)
        } else {
            Toast.makeText(getApplicationContext(), "Заказов больше нет!", Toast.LENGTH_SHORT).show()
        }


    }

    fun stop(view: View) {
        showHide(findViewById<LinearLayout>(R.id.order))
        showHide(findViewById<LinearLayout>(R.id.linearLayout))
        showHide(findViewById<LinearLayout>(R.id.relativeLayout))
    }
}