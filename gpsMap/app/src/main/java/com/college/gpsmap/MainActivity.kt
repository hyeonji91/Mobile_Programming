package com.college.gpsmap

import android.Manifest
import android.R
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.college.gpsmap.databinding.ActivityMainBinding
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.mapwidget.InfoWindowOptions
import com.kakao.vectormap.mapwidget.component.GuiImage
import com.kakao.vectormap.mapwidget.component.GuiLayout
import com.kakao.vectormap.mapwidget.component.GuiText
import com.kakao.vectormap.mapwidget.component.Orientation
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        RequestPermissionsUtil(this).requestLocation()

//        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        var curLocation :Location? = null
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                RequestPermissionsUtil(this).permissionsLocationDownApi29Impl,
//                RequestPermissionsUtil(this).REQUEST_LOCATION
//            )
//            curLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//        }

//        val lat = curLocation!!.latitude //위도
//        val lng = curLocation!!.longitude //경도


//        val uNowPosition = MapPoint.mapPointWithGeoCoord(lat!!, lng!!)


        val kakaoMapView = MapView(this)
//        kakaoMapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        kakaoMapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
        kakaoMapView.setShowCurrentLocationMarker(true)
        binding.mapLayout.addView(kakaoMapView)
//
//        var lat = kakaoMapView.mapCenterPoint.mapPointGeoCoord.latitude
//        var lng = kakaoMapView.mapCenterPoint.mapPointGeoCoord.longitude
//        val uNowPosition = MapPoint.mapPointWithGeoCoord(lat!!, lng!!)
        var lat = getLatLng().latitude
        var lng = getLatLng().longitude

        Log.d("latlng", ""+lat+" "+lng)
        var geocoder = Geocoder(this, Locale.KOREA)
        var add = geocoder.getFromLocation(lat, lng,1)
        binding.textView.text = add?.get(0)?.getAddressLine(0)//주소명


    }

    private fun getLatLng(): Location{
        var currentLatLng: Location? = null
        var hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)
        var hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION)

        if(hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
            hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED){
            val locatioNProvider = LocationManager.GPS_PROVIDER
            var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            currentLatLng = locationManager?.getLastKnownLocation(locatioNProvider)
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, RequestPermissionsUtil(this).permissionsLocationDownApi29Impl[0])){
                Toast.makeText(this, "앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(this, RequestPermissionsUtil(this).permissionsLocationDownApi29Impl, 1)
            }else{
                ActivityCompat.requestPermissions(this, RequestPermissionsUtil(this).permissionsLocationDownApi29Impl, 1)
            }
            currentLatLng = getLatLng()
        }
        return currentLatLng!!
    }

}