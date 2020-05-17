package com.example.hvaquest.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hvaquest.R


/**
 * A simple [Fragment] subclass.
 * Use the [LocationClueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationClueFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_clue, container, false)
    }
}
