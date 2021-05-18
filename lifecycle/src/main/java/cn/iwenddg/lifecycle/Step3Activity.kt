package cn.iwenddg.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import cn.iwenddg.lifecycle.databinding.ActivityMainBinding
import cn.iwenddg.lifecycle.databinding.ActivityMainTwoBinding

class Step3Activity : AppCompatActivity() {
    // 使用viewBinding
    private lateinit var binding: ActivityMainTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

    }

    // 开启服务
    fun start(view: View) {
        startService(Intent().setClass(this,MyLocationService::class.java))
    }

    // 停止服务
    fun stop(view: View) {
        stopService(Intent().setClass(this,MyLocationService::class.java))
    }
}