package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // to check if there is current operation or not
    var isNewOp =true

    // function to add numbers to display screen
    fun numberEvent(view: View){

        //  if is it a new operation clear the screen
        if(isNewOp){
            binding.show.text = ""
        }
        isNewOp =false

        // get current number displayed in the screen
        var tvNumber =binding.show.text.toString()

        val buSelected =view as Button

        when(buSelected.id){
            binding.bu0.id ->{
                tvNumber +="0"
            }
            binding.bu1.id ->{
                tvNumber +="1"
            }
            binding.bu2.id ->{
                tvNumber +="2"
            }
            binding.bu3.id ->{
                tvNumber +="3"
            }
            binding.bu4.id ->{
                tvNumber +="4"
            }
            binding.bu5.id ->{
                tvNumber +="5"
            }
            binding.bu6.id ->{
                tvNumber +="6"
            }
            binding.bu8.id ->{
                tvNumber +="8"
            }
            binding.bu9.id ->{
                tvNumber +="9"
            }
            binding.bu0.id ->{
                tvNumber +="0"
            }
        }
        binding.show.text = tvNumber
    }



    // declare a variable to save first number on it
    var oldNumber =""
    var op =""
    fun op (view: View){
        oldNumber =binding.show.text.toString()
        binding.show.text = ""

        val selected =view as Button
        when(selected.id){
            binding.buMinus.id ->{
                op ="-"
            }
            binding.buDiv.id ->{
                op ="/"
            }
            binding.buD.id ->{
                op ="*"
            }
            binding.buAdd.id ->{
                op ="+"
            }
        }

        binding.show.text = ""
    }




    fun buEqual(view: View){
        Toast.makeText(applicationContext, oldNumber+""+op, Toast.LENGTH_SHORT).show()

        val newNumber =binding.show.text.toString()
        var finalNumber :Double?=null
        when(op){
            "+" ->{
                finalNumber =oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" ->{
                finalNumber =oldNumber.toDouble() - newNumber.toDouble()
            }
            "*" ->{
                finalNumber =oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" ->{
                finalNumber =oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        binding.show.text =finalNumber.toString()
        isNewOp = true

    }


}
