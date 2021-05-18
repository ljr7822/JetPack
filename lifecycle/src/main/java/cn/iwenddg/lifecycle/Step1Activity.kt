package cn.iwenddg.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import cn.iwenddg.lifecycle.databinding.ActivityMainBinding

class Step1Activity : AppCompatActivity() {
    // 全局chronometer
    private lateinit var chronometer: Chronometer

    private var elapsedRealtime = 0L

    // 使用viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        // 找到这个控件
        chronometer = binding.chronometer

    }

    override fun onResume() {
        super.onResume()
        // 起始时间
        chronometer.base = SystemClock.elapsedRealtime() - elapsedRealtime
        chronometer.start()
    }

    override fun onPause() {
        super.onPause()
        // 休息时间
        elapsedRealtime = SystemClock.elapsedRealtime() - chronometer.base
        chronometer.stop()
    }
}