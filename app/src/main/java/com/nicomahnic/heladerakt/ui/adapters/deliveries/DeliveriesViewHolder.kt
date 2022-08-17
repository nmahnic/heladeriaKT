package com.nicomahnic.heladerakt.ui.adapters.deliveries

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.databinding.ItemDeliveriesBinding
import com.nicomahnic.heladerakt.domain.models.Delivery

class DeliveriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemDeliveriesBinding.bind(view)


    fun render(delivery: Delivery, position: Int, onClickListener: DeliveriesAdapter.ItemListener){
        binding.tvName.text = delivery.name
        binding.tvAddress.text = delivery.address
        binding.tvNumber.text = delivery.whatsappNumber

        if(delivery.address.isEmpty()) binding.tvAddress.visibility = View.GONE else View.VISIBLE

        itemView.setOnClickListener {
            onClickListener.onBtnClick( delivery ,position )
        }
    }
}