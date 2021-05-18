package cn.iwenddg.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import cn.iwenddg.lifecycle.databinding.ActivityMainBinding

class Step2Activity : AppCompatActivity() {
    // 全局chronometer
    private lateinit var chronometer: MyChronometer

    // 使用viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        // 找到这个控件
        chronometer = binding.chronometer
        // 添加生命周期监听
        lifecycle.addObserver(chronometer)
    }
}