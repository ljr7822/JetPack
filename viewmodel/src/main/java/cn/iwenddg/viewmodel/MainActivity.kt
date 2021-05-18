package cn.iwenddg.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import cn.iwenddg.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 使用viewBinding
    private lateinit var binding:ActivityMainBinding

    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root =  binding.root
        setContentView(root)

        // 绑定viewModel
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MyViewModel::class.java)
        binding.tv.text = viewModel.number.toString()
    }

    fun plusNum(view: View) {
        binding.tv.text = (++viewModel.number).toString()
    }
}