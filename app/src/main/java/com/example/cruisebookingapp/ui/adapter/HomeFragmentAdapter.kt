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

class HomeFragmentAdapter(val shipList : List<Ship>, val fragmentManager : FragmentManager ) : RecyclerView.Adapter<HomeFragmentAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val shipCard : CardView = itemView.findViewById(R.id.shipCard)
        val shipImage : ImageView = itemView.findViewById(R.id.shipImage)
        val shipName : TextView = itemView.findViewById(R.id.shipName)
        val shipType : TextView = itemView.findViewById(R.id.shipType)
        val context : Context =  itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder{
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.ship_card, parent, false)
        return HomeViewHolder(layoutInflater)
    }


    override fun getItemCount(): Int {
        return shipList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val ship = shipList.get(position)

        Glide.with(holder.context)
            .load(ship.image)
            .error(R.drawable.holder)
            .into(holder.shipImage)
        holder.shipName.text = ship.ship_name
        holder.shipType.text = ship.ship_type

        holder.shipCard.setOnClickListener {
            val bottomFrag = BottomFragment.newInstance(ship.ship_id)
            bottomFrag.show(fragmentManager, BottomFragment.toString())
        }
    }



}