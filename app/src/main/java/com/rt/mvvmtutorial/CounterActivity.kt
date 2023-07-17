package com.rt.mvvmtutorial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rt.mvvmtutorial.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCounterBinding
    lateinit var viewModel: CounterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intentString = intent?.extras?.getString("Sample")
        Log.d("CounterActivity", intentString.toString())

        binding = DataBindingUtil.setContentView(this, R.layout.activity_counter)
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        binding.lifecycleOwner = this
        binding.counterViewModel = viewModel

    }
}