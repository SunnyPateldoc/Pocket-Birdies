package com.example.pocketbirdies.fragment

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import org.osmdroid.api.IMapController
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Marker.OnMarkerClickListener


class NearMeFragment : Fragment() {

    val permission = arrayOf("android.permission.ACCESS_FINE_LOCATION","android.permission.READ_EXTERNAL_STORAGE")

    lateinit var mapView : MapView
    lateinit var mMapController : MapController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = (requireActivity() as AppCompatActivity)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_feather_menu)


        val view = inflater.inflate(R.layout.fragment_near_me, container, false)


        requireActivity().requestPermissions(permission,55)

        mapView = view.findViewById(R.id.map_view)


        mapViewShow()





        return view
    }

    override fun onResume() {
        super.onResume()

        org.osmdroid.config.Configuration.getInstance().load(requireContext(),PreferenceManager.getDefaultSharedPreferences(requireContext()))


        val activity = (requireActivity() as Home)

        val isBottome = activity.isBottomViewVisible
        val isHome = activity.isHomeActionBar
        val isSecond = activity.isSecondActionBar
        val isChat = activity.isChatActionBar
        val getTitle = activity.setTitle
        val getBack = activity.setBack

        activity.setFragmetActive(isBottome, isHome, isSecond, isChat, getTitle, getBack)
    }


    private fun mapViewShow() {

        org.osmdroid.config.Configuration.getInstance().load(requireContext(),PreferenceManager.getDefaultSharedPreferences(requireContext()))

        val mapController: IMapController = mapView.getController()
        mapController.setZoom(13)
        //mapView.setScrollableAreaLimitDouble(BoundingBox(85.0, 180.0, -85.0, -180.0))
        //mapView.setScrollableAreaLimitLatitude(MapView.getTileSystem().getMaxLatitude(), MapView.getTileSystem().getMinLatitude(), 0)
        val startPoint = GeoPoint(23.026435, 72.524308)
        mapController.setCenter(startPoint)
        mapController.animateTo(startPoint)

        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)

        mapView.isHorizontalMapRepetitionEnabled = false
        mapView.isVerticalMapRepetitionEnabled = false
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        mapView.invalidateMapCoordinates(5,5,5,5)

        /*val myLocationOverlayItem = OverlayItem("Here", "Current Position", startPoint)
        val marker = ContextCompat.getDrawable(requireContext(), R.drawable.icon_ionic_ios_pin)
        myLocationOverlayItem.setMarker(marker)
*/
        val startMarker = Marker(mapView)
        startMarker.setPosition(startPoint)
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        mapView.overlays.add(startMarker)


        val newMark = Marker(mapView)
        newMark.position = GeoPoint(23.027461,72.506941)
        newMark.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        newMark.title = "Sunny Patel"
        val d = requireContext().getDrawable(R.drawable.icon_pin)


        newMark.icon = d
        mapView.overlays.add(newMark)
        mapView.invalidate()

        /*val newMark = Marker(mapView)
        newMark.setPosition(GeoPoint(23.027461,72.506941))
        newMark.image = requireContext().getDrawable(R.drawable.icon_ionic_ios_pin)
        mapView.overlays.add(startMarker)*/

        startMarker.setOnMarkerClickListener(object : OnMarkerClickListener{
            override fun onMarkerClick(marker: Marker?, mapView: MapView?): Boolean {

                findNavController().navigate(R.id.nearMeDialogFragment)

                return true
            }

        })
        
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == 55){

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                mapViewShow()
            }

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


}