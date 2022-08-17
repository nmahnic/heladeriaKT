package com.nicomahnic.heladerakt.ui.adapters.combos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.databinding.ItemSubtastesBinding
import com.nicomahnic.heladerakt.domain.models.Taste

class SubTastesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemSubtastesBinding.bind(view)

    fun render(taste: Taste){
        binding.tvName.text = taste.name
    }
}