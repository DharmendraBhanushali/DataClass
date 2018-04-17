package com.dharmendra.dataclass

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find View By Id For Listview
        val listView = findViewById<ListView>(R.id.listView)


        //Array That contain names which we add to our DataModel Class
        val names = arrayOf("Dharmendra", "Vishal", "Sachin", "Raj", "Jatin", "Krishank", "Rishu")

        //Initialize ArrayList of DataModel Class
        var list = ArrayList<DataModel>()


        //For loop that add name From names Array and index as Id in DataModel Class
        //Add object of DataModel in to ArrayList

        for (i in 0 until names.size) {

            val myData = DataModel(i, names[i])

            list.add(myData)

        }

        //We Have Created Custom Adapter Class in that we pass Context,ArrayList of DataModel
        val customAdapter = CustomAdapter(this, list)

        //Set Adapter to ArrayList
        listView.adapter = customAdapter

        //On Click for ListView Item
        listView.setOnItemClickListener { parent, view, position, id ->

            val name = customAdapter.getItem(position).name
            val id = customAdapter.getItem(position).id

            Toast.makeText(this, "Name:$name\n Id: $id", Toast.LENGTH_LONG).show()
        }


    }


}


//DataModel Class which take and store id and name
data class DataModel(var id: Int, var name: String)