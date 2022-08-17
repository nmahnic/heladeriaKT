package com.nicomahnic.heladerakt.ui.adapters.combos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.domain.models.Combo

class CombosAdapter(
    private var combosList: MutableList<Combo>,
) : RecyclerView.Adapter<CombosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CombosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return CombosViewHolder(layoutInflater.inflate(R.layout.item_combos, parent, false))
    }

    override fun onBindViewHolder(holder: CombosViewHolder, position: Int) {
        val item = combosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = combosList.size

}