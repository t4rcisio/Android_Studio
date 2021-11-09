package com.example.guests_20.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guests_20.R
import com.example.guests_20.service.model.GuestModel
import com.example.guests_20.view.GuestForm
import com.example.guests_20.view.listner.GuestListener
import com.example.guests_20.view.viewHolder.GuestViewHolder

class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {


    private var mGuestList : List<GuestModel> = arrayListOf()
    private lateinit var mGuestListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item, mGuestListener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    fun updateGuests(list : List<GuestModel>){
        mGuestList = list
        notifyDataSetChanged()
    }

    fun attachListner(guestListener: GuestListener){
        mGuestListener = guestListener
    }

}