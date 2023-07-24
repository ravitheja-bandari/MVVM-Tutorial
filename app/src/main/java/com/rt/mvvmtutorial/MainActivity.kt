package com.rt.mvvmtutorial

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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

        Log.d("lifecycleMethod","onCreate")
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

    override fun onStart() {
        super.onStart()
        Log.d("lifecycleMethod","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycleMethod","onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("lifecycleMethod","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("lifecycleMethod","onRestoreInstanceState")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycleMethod","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycleMethod","onStop")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("lifecycleMethod","onBackPressed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycleMethod","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifecycleMethod","onRestart")
    }
}