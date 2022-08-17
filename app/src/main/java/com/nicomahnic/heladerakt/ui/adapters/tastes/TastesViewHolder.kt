package com.nicomahnic.heladerakt.ui.adapters.tastes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.databinding.ItemTastesBinding
import com.nicomahnic.heladerakt.domain.models.TasteOption

class TastesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemTastesBinding.bind(view)

    fun render(taste: TasteOption, onClickListener: TastesAdapter.ItemListener){
        binding.checkBox.text = taste.name

        binding.checkBox.setOnClickListener{
            onClickListener.onBtnClick(taste)
        }
    }
}