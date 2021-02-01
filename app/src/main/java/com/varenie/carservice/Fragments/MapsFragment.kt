package com.varenie.carservice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.varenie.carservice.R
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView


//надо будет потом разобраться с этим
class MapsFragment : Fragment() {

    private var mapview: MapView? = null
    private val API_KEY = "de6286aa-d1b5-451d-a2e9-6a82791fa0fc"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MapKitFactory.setApiKey(API_KEY)
        MapKitFactory.initialize(requireContext())

        val root = inflater.inflate(R.layout.fragment_maps, null)

        mapview = root.findViewById(R.id.mapView)
        mapview?.map?.move(
            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )

        return root
    }

    override fun onStop() {
        super.onStop()
        mapview?.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        mapview?.onStart()
        MapKitFactory.getInstance().onStart()
    }
}