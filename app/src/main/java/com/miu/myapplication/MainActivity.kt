package com.miu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var foodList: ArrayList<String> = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //textFoodName.text = "test";
        binding.textFoodName.text= foodList.random();

        binding.addBtn.setOnClickListener{
            if(binding.textAddFood.text.trim().isNullOrEmpty()){
                binding.textAddFood.error = "Please set a valid food.";
            }else{
                if(! foodList.contains(binding.textAddFood.text.toString())){
                    foodList.add(binding.textAddFood.text.toString());
                    binding.textFoodName.setText(binding.textAddFood.text.toString());
                    binding.textAddFood.setText("");
                }else{
                    binding.textAddFood.error = "Food is already exists.";
                }
            }
        }
        binding.decideBtn.setOnClickListener {
            binding.textFoodName.text = foodList.random();
        }



    }
}