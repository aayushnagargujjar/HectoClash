package com.example.hectoclash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import android.view.ViewGroup
import com.example.hectoclash.more.Profile


class More : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_more, container, false)
        val btnProfile = view.findViewById<CardView>(R.id.moreProfile)
        btnProfile.setOnClickListener{
            val intent = Intent(requireContext(), Profile::class.java)
            startActivity(intent)
        }






        return inflater.inflate(R.layout.fragment_more, container, false)
    }

}