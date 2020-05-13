package com.example.navigationdrawer

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Transformations.map
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        this.setTitle("Contact")
        text_address.text="Address: \nNo. 311/ 19,\n2nd Floor, 1st Main Rd,\n8th Block, Jayanagar,\nBengaluru, Karnataka-560082"

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val number:String="+91 9036118406"
        val email:String="mobinius@mobinius.com"
        text_phoneNumber.text="Phone no: "+number
        text_email.text="Email:"+email

        text_phoneNumber.setOnClickListener{
            val intent=Intent(Intent.ACTION_DIAL)
           val no:String="tel:"+number
            intent.setData(Uri.parse(no))
            startActivity(intent)
        }
        text_email.setOnClickListener{
            val emailIntent=Intent(Intent.ACTION_SEND)
            emailIntent.setData(Uri.parse("mailto:"+email))
            // emailIntent.putExtra(Intent.EXTRA_EMAIL, email)
            startActivity(emailIntent)
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val mobinius = LatLng(12.920123, 77.576307)
        mMap.addMarker(MarkerOptions().position(mobinius).title("Mobinius"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mobinius))
    }
}
