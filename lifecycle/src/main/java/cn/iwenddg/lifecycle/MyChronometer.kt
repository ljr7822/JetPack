package cn.iwenddg.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 自定义Chronometer，添加生命周期监听
 * @author iwen大大怪
 * @Create 2021/05/18 15:21
 */
class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs),
    LifecycleObserver {

    private var elapsedRealtime = 0L

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startMeter() {
        // 起始时间
        base = SystemClock.elapsedRealtime() - elapsedRealtime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopMeter() {
        // 休息时间
        elapsedRealtime = SystemClock.elapsedRealtime() - base
        stop()
    }
}