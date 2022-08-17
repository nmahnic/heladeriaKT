package com.nicomahnic.heladerakt.ui.adapters.opciones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.domain.models.IceCreamOption

class IceCreamOptionsAdapter(
    private var empandasList: MutableList<IceCreamOption>,
    private val btnListener: BtnListener
) : RecyclerView.Adapter<IceCreamOptionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IceCreamOptionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return IceCreamOptionsViewHolder(layoutInflater.inflate(R.layout.item_options, parent, false))
    }

    override fun onBindViewHolder(holder: IceCreamOptionsViewHolder, position: Int) {
        val item = empandasList[position]
        holder.render(item, btnListener)
    }

    override fun getItemCount(): Int = empandasList.size

    interface BtnListener{
        fun onBtnClick(iceCreamOption: IceCreamOption)
    }

}