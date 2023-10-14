package com.cz.myapplication

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val con:Context): ViewModel() {
     var quoteList:Array<DataModel> = emptyArray()
     var index=0
    
    init {
        quoteList=loadQFromAseet()
    }

    private fun loadQFromAseet(): Array<DataModel> {
        val inputStream = con.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer,Charsets.UTF_8)
        val gson=Gson()
        return gson.fromJson(json,Array<DataModel>::class.java)

    }

    fun getQ()= quoteList[index]
    fun nextQ():DataModel{
        if(quoteList.lastIndex<index){
            index=0


        }

            return quoteList[index++]


    }
    fun previous():DataModel {
        if (index<0) {
            index = quoteList.lastIndex


        }

        return quoteList[index--]

    }
}
