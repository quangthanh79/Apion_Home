package com.apion.apionhome.ui.home.FragmentDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.apion.apionhome.R
import com.apion.apionhome.data.model.Photo
import kotlinx.android.synthetic.main.fragment_photo.*

class PhotoFragment : Fragment() {
    var view1 : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.fragment_photo, container, false)
        var bundle = arguments
        var photo = bundle?.get("object_photo") as Photo
        img_photo.setImageResource(photo.resource)
        return view1



    }
}