package cn.iwenddg.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleService

/**
 * 自定义的locationService
 *
 * @author iwen大大怪
 * @Create 2021/05/18 15:47
 */
class MyLocationService() : LifecycleService() {

    init {
        Log.d("ljr","MyLocationService")
        // 将自定义的观察者对象添加到观察者集合中
        // 通过lifecycle将观察者和被观察者关联起来
        val observer = MyLocationObserver(this)
        lifecycle.addObserver(observer)
    }
}