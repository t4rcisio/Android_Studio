package com.example.guests_20.view.viewHolder

import android.app.AlertDialog
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guests_20.R
import com.example.guests_20.service.model.GuestModel
import com.example.guests_20.service.repository.GuestRepository
import com.example.guests_20.view.listner.GuestListener
import kotlinx.android.synthetic.main.row_guest.view.*

class GuestViewHolder(view: View, private var guestListener: GuestListener): RecyclerView.ViewHolder(view) {

    fun bind(guestModel: GuestModel){
        val rowGuest = itemView.findViewById<TextView>(R.id.guestName)
        rowGuest.text = guestModel.name

        rowGuest.setOnClickListener{
            guestListener.onClick(guestModel.id)
        }

        rowGuest.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Delete ${rowGuest.text}")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes"){ dialog, wich ->

                    guestListener.onDelete(guestModel.id)
                }
                .setNegativeButton("Cancel"){ dialog, wich ->
                    guestListener.onCancel()
                }
                .show()
            true
        }

    }



}