package com.nicomahnic.heladerakt.ui.adapters.combos

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.databinding.ItemCombosBinding
import com.nicomahnic.heladerakt.domain.models.Combo

class CombosViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemCombosBinding.bind(view)

    fun render(combo: Combo){
        binding.tvName.text = combo.name

        val rvTastes = binding.rvTastes
        rvTastes.layoutManager = LinearLayoutManager(view.context)
        rvTastes.adapter = SubTastesAdapter(combo.tasteList)
    }
}