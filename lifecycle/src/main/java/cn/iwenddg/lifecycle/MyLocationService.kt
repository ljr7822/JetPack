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
        val observer = MyLocationObserver(this)
        lifecycle.addObserver(observer)
    }
}