package cn.iwenddg.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import cn.iwenddg.livedata.databinding.ActivityMainBinding
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    // 使用viewBinding
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        // 拿到viewModel
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MyViewModel::class.java)

        // 给viewModel设置监听者
        viewModel.liveData.observe(this, androidx.lifecycle.Observer {
            binding.tv.text = it.toString()
        })
        // 开启定时器
        startTime()
    }

    // 定时器：每隔一秒修改一次viewModel的值
    fun startTime() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                viewModel.liveData.postValue(viewModel.liveData.value?.plus(1))
            }
        }, 1000, 1000)
    }
}