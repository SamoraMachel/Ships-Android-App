package com.example.cruisebookingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.cruisebookingapp.ui.viewmodel.BottomFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val SHIP_ID = "ship_id"

class BottomFragment : BottomSheetDialogFragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(SHIP_ID)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val btmView = inflater.inflate(R.layout.fragment_bottom, container, false)

        val shipImage : ImageView = btmView.findViewById(R.id.btmShipImage)
        val shipTitle : TextView =  btmView.findViewById(R.id.btmShipName)
        val shipType : TextView = btmView.findViewById(R.id.btmShipType)
        val shipPort : TextView = btmView.findViewById(R.id.shipHomePort)

        val viewModel : BottomFragmentViewModel = ViewModelProvider(this).get(BottomFragmentViewModel::class.java)



        return btmView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            BottomFragment().apply {
                arguments = Bundle().apply {
                    putString(SHIP_ID, param1)
                }
            }
    }
}