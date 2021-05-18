package cn.iwenddg.lifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

/**
 * 针对整个应用程序的监听，与activity数量无关
 * Lifecycle.Event.ON_CREATE 只调用一次
 * Lifecycle.Event.ON_DESTROY 永远不会被调用
 *
 * @author iwen大大怪
 * @Create 2021/05/18 20:06
 */
class MyApplication : Application() {

    private lateinit var applicationObserver: ApplicationObserver

    override fun onCreate() {
        super.onCreate()
        applicationObserver = ApplicationObserver()
        ProcessLifecycleOwner.get().lifecycle.addObserver(applicationObserver)
    }
}