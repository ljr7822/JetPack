package cn.iwenddg.lifecycle

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author iwen大大怪
 * @Create 2021/05/18 15:50
 */
class MyLocationObserver(private val context: Context) : LifecycleObserver {

    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startGetLocation() {
        Log.d("ljr","startGetLocation")
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = MyLocationListener()
        if (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000,
            0.01f,
            locationListener
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopGetLocation() {
        Log.d("ljr","stopGetLocation")
        locationManager.removeUpdates(locationListener)
    }

    inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d("ljr", "location changed$location")
        }
    }
}