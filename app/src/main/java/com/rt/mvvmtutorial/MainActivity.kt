package com.rt.mvvmtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rt.mvvmtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CounterViewModel
    lateinit var viewModelFactory: CounterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = CounterViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CounterViewModel::class.java)

        binding.apply {
            tvCount.text = viewModel.getCurrentCounter().toString()
            btnCount.setOnClickListener(View.OnClickListener {
                tvCount.text = viewModel.getUpdatedCounter().toString()
            })
        }

    }
}