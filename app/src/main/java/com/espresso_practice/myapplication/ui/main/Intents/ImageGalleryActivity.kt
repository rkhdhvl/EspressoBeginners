package com.espresso_practice.myapplication.ui.main.Intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.bumptech.glide.Glide
import com.espresso_practice.myapplication.R
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.activity_camera.image
import kotlinx.android.synthetic.main.activity_gallery_.*


const val GALLERY_REQUEST_CODE = 1234
class ImageGalleryActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_)
        button_open_gallery.setOnClickListener {
            pickFromGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
        {
            when(requestCode)
            {
              GALLERY_REQUEST_CODE -> {
                 data?.data?.let { uri ->
                     Log.d(TAG, "URI: $uri")
                     Glide.with(this)
                         .load(uri)
                         .into(image)
                 }
              }
            }
        }
    }

    private fun pickFromGallery()
    {
     val intent =Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

}
