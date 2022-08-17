package com.nicomahnic.heladerakt.ui.adapters.combos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.domain.models.Taste

class SubTastesAdapter(
    private var tasteList: List<Taste>,
) : RecyclerView.Adapter<SubTastesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTastesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return SubTastesViewHolder(layoutInflater.inflate(R.layout.item_subtastes, parent, false))
    }

    override fun onBindViewHolder(holder: SubTastesViewHolder, position: Int) {
        val item = tasteList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = tasteList.size

}