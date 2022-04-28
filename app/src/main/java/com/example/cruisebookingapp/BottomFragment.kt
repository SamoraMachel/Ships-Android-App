package com.example.cruisebookingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cruisebookingapp.data.model.Ship
import com.example.cruisebookingapp.ui.viewmodel.BottomFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

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
        val shipChipGroup : ChipGroup = btmView.findViewById(R.id.btmRoleChipGrp)

        val viewModel : BottomFragmentViewModel = ViewModelProvider(this).get(BottomFragmentViewModel::class.java)

        val shipLiveData : LiveData<Ship?>? = param1?.let { viewModel.getShip(requireContext(), it) }
        shipLiveData?.observe(this, Observer {
            it?.let {
                Glide.with(requireContext())
                    .load(it.image)
                    .into(shipImage)

                shipTitle.text = it.ship_name
                shipType.text = it.ship_type
                shipPort.text = it.home_port
                for (role in it.roles) {
                    val chip = Chip(context)
                    chip.text = role
                    shipChipGroup.addView(chip)
                }
            }
        })

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