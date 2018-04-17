package com.dharmendra.dataclass

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


/*We Have Created Constructor of Custom Adapter and Pass
                context
                ArrayList<DataModel> which Contain our Data
                */

//Here We extend over Adapter With BaseAdapter()


class CustomAdapter(context: Context, list: ArrayList<DataModel>) : BaseAdapter() {


    //Passing Values to Local Variables

    private var list = list
    private var context = context


    //Auto Generated Method

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var myView = convertView
        val holder: ViewHolder

        if (convertView == null) {


            //If Over View is Null than we Inflater view using Layout Inflater

            val mInflater = (context as Activity).layoutInflater

            //Inflating our list_row.

            myView = mInflater.inflate(R.layout.list_row, parent, false)

            //Create Object of ViewHolder Class and set our View to it

            holder = ViewHolder()

            //Find view By Id For all our Widget taken in list_row.

            /*Here !! are use for non-null asserted two prevent From null.
             you can also use Only Safe (?.)

            */


            holder.name = myView!!.findViewById(R.id.name)
            holder.id = myView.findViewById(R.id.id)

            //Set A Tag to Identify our view.

            myView.setTag(holder)


        } else {

            //If Ouer View in not Null than Just get View using Tag and pass to holder Object.

            holder = myView!!.getTag() as ViewHolder
        }


        //Getting our data at position of List
        val data = getItem(position)


        //Set Name to our TextView
        holder.name!!.text = data.name

        //Set Id to our TextView
        holder.id!!.text = data.id.toString()


        return myView
    }

    //Auto Generated Method

    override fun getItem(position: Int): DataModel {
        //Return the Data at Position of ArrayList.
        return list.get(position)
    }


    //Auto Generated Method

    override fun getItemId(position: Int): Long {
        return 0
    }

    //Auto Generated Method

    override fun getCount(): Int {

        //Return Size Of ArrayList
        return list.size
    }

    //Create A class To hold over View like we taken in list_row.xml
    class ViewHolder {

        var name: TextView? = null
        var id: TextView? = null

    }
}