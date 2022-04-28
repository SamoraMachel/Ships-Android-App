package com.example.cruisebookingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cruisebookingapp.R
import com.example.cruisebookingapp.ui.adapter.HomeFragmentAdapter
import com.example.cruisebookingapp.ui.viewmodel.HomeFragmentViewModel


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainView = inflater.inflate(R.layout.fragment_home, container, false)

        val viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        // setup the recycler view
        val shipRecycler : RecyclerView =  mainView.findViewById(R.id.shipRecyclerView)
        shipRecycler.adapter = HomeFragmentAdapter(viewModel.shipList(requireContext()))
        shipRecycler.layoutManager = StaggeredGridLayoutManager(R.integer.home_grid_span, StaggeredGridLayoutManager.VERTICAL)


        return mainView
    }


}