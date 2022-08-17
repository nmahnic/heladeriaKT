package com.nicomahnic.heladerakt.ui.adapters.deliveries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.domain.models.Delivery

class DeliveriesAdapter(
    private var deliveryList: MutableList<Delivery>,
    private val itemListener: ItemListener
) : RecyclerView.Adapter<DeliveriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return DeliveriesViewHolder(layoutInflater.inflate(R.layout.item_deliveries, parent, false))
    }

    override fun onBindViewHolder(holder: DeliveriesViewHolder, position: Int) {
        val item = deliveryList[position]
        holder.render(item, position, itemListener)
    }

    override fun getItemCount(): Int = deliveryList.size

    interface ItemListener{
        fun onBtnClick(delivery: Delivery, position: Int)
    }

}