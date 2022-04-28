package com.example.cruisebookingapp.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cruisebookingapp.R
import com.example.cruisebookingapp.ui.adapter.HomeFragmentAdapter
import com.example.cruisebookingapp.ui.adapter.SearchAdapter
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
        val searchView : SearchView = mainView.findViewById(R.id.shipSearchView)

        val shipRecycler : RecyclerView =  mainView.findViewById(R.id.shipRecyclerView)
        val homeFragmentManager = this.requireFragmentManager()

        // setup the recycler view
        viewModel.getShipList(requireContext()).observe(viewLifecycleOwner, Observer {
            shipRecycler.adapter = HomeFragmentAdapter(it, homeFragmentManager)
            shipRecycler.layoutManager =  GridLayoutManager(requireContext(), resources.getInteger(R.integer.home_grid_span)) //StaggeredGridLayoutManager(R.integer.home_grid_span, StaggeredGridLayoutManager.VERTICAL)


            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    shipRecycler.adapter = p0?.let { it1 ->
                        SearchAdapter(it, homeFragmentManager).search(it1)
                    }

                    shipRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    shipRecycler.adapter = p0?.let { it1 ->
                        SearchAdapter(it, homeFragmentManager).search(it1)
                    }

                    shipRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    return true
                }

            })
        })




        return mainView
    }


}