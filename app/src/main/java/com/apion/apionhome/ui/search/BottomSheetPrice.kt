package com.apion.apionhome.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apion.apionhome.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetPrice :  BottomSheetDialogFragment(){
    fun BottomSheetPrice() {
        // Required empty public constructor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.SheetDialog)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bottomsheet_price, container, false)
    }
}