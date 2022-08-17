package com.nicomahnic.heladerakt.ui.adapters.opciones

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.databinding.ItemOptionsBinding
import com.nicomahnic.heladerakt.domain.models.IceCreamOption

class IceCreamOptionsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemOptionsBinding.bind(view)

    fun render(iceCreamOption: IceCreamOption, btnListener: IceCreamOptionsAdapter.BtnListener){
        binding.tvName.text = iceCreamOption.name

        binding.card.setOnClickListener {
            btnListener.onBtnClick(iceCreamOption)
        }
    }
}