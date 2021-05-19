package cn.iwenddg.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author iwen大大怪
 * @Create 2021/05/19 9:10
 */
class MyViewModel : ViewModel() {
    // 对外变量 保证数据安全
    var liveData = MutableLiveData<Int>()

    // 立即初始化
    init {
        liveData.postValue(0)
    }
}