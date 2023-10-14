package com.cz.pppppp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.cz.myapplication.DataModel
import com.cz.myapplication.MainViewModel
import com.cz.myapplication.MainViewModelFactory
import com.cz.pppppp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)


        setQ(mainViewModel.getQ())
        binding.next.setOnClickListener {
            setQ(mainViewModel.nextQ())

        }
        binding.pre.setOnClickListener {
            setQ(mainViewModel.previous())
            Toast.makeText(this,"work", Toast.LENGTH_LONG).show()
        }


        setContentView(binding.root)



    }
    fun setQ(quots: DataModel){
        binding.text.text=quots.text
        binding.author.text=quots.name
    }


}