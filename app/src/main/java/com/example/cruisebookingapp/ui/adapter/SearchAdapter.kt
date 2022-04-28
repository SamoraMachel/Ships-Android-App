package com.example.cruisebookingapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cruisebookingapp.BottomFragment
import com.example.cruisebookingapp.R
import com.example.cruisebookingapp.data.model.Ship

class SearchAdapter(val shipList : List<Ship>, val fragmentManager : FragmentManager) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    private val searchList : MutableList<Ship> = mutableListOf()

    init {
        searchList.addAll(shipList)
    }

    class SearchViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val shipCard : CardView = itemView.findViewById(R.id.searchShipCard)
        val shipImage : ImageView = itemView.findViewById(R.id.searchShipImage)
        val shipName : TextView = itemView.findViewById(R.id.searchShipName)
        val shipType : TextView = itemView.findViewById(R.id.searchShipType)
        val context : Context = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater : View = LayoutInflater.from(parent.context).inflate(R.layout.ship_search_card, parent, false)
        return SearchViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val _ship = searchList[position]

        Glide.with(holder.context)
            .load(_ship.image)
            .error(R.drawable.holder)
            .into(holder.shipImage)

        holder.shipName.text = _ship.ship_name
        holder.shipType.text = _ship.ship_type

        holder.shipCard.setOnClickListener {
            val bottomFrag = BottomFragment.newInstance(_ship.ship_id)
            bottomFrag.show(fragmentManager, BottomFragment.toString())
        }
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    fun search(value : String): SearchAdapter {
        searchList.clear()
        if(value != "" ) {
            for(ship in shipList) {
                if (ship.ship_name.contains(value))
                    searchList.add(ship)
                else if(ship.ship_type.contains(value))
                    searchList.add(ship)
                else if(ship.ship_model?.contains(value) == true)
                    searchList.add(ship)
            }
        } else {
            searchList.addAll(shipList)
        }
        notifyDataSetChanged()
        return this
    }

}