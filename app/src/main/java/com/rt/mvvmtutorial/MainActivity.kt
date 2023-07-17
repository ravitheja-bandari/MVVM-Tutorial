package com.rt.mvvmtutorial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rt.mvvmtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //View Model Example
    lateinit var counterViewModel: CounterViewModel
    lateinit var counterViewModelFactory: CounterViewModelFactory

    //Live data Example
    lateinit var sumUpViewModel: SumUpViewModel
    lateinit var sumUpViewModelFactory: SumUpViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        counterViewModelFactory = CounterViewModelFactory(100)
        counterViewModel =
            ViewModelProvider(this, counterViewModelFactory).get(CounterViewModel::class.java)

        binding.apply {
            tvCount.text = counterViewModel.getCurrentCounter().toString()
            btnCount.setOnClickListener {
                tvCount.text = counterViewModel.getUpdatedCounter().toString()
            }
        }

        //Live Data Code
        sumUpViewModelFactory = SumUpViewModelFactory(200)
        sumUpViewModel =
            ViewModelProvider(this, sumUpViewModelFactory).get(SumUpViewModel::class.java)


        //Observing for any data change
        sumUpViewModel.sum.observe(this, Observer {
            binding.tvResult.text = it.toString()
        })

        binding.apply {
            btnAdd.setOnClickListener {
                sumUpViewModel.addInput(etAddText.text.toString().toInt())
            }
        }

        binding.btnNavigate.setOnClickListener {
            val intent = Intent(this, CounterActivity::class.java)
            intent.putExtra("Sample", "value")
            startActivity(intent)
        }

    }
}