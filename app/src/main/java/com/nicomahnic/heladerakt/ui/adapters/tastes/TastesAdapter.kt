package com.nicomahnic.heladerakt.ui.adapters.tastes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.domain.models.TasteOption

class TastesAdapter(
    private var tasteList: MutableList<TasteOption>,
    private val itemListener: ItemListener
) : RecyclerView.Adapter<TastesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TastesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return TastesViewHolder(layoutInflater.inflate(R.layout.item_tastes, parent, false))
    }

    override fun onBindViewHolder(holder: TastesViewHolder, position: Int) {
        val item = tasteList[position]
        holder.render(item, itemListener)
    }

    override fun getItemCount(): Int = tasteList.size

    interface ItemListener{
        fun onBtnClick(taste: TasteOption)
    }

}