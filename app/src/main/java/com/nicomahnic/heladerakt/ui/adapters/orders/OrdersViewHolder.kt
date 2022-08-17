package com.nicomahnic.heladerakt.ui.adapters.orders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.databinding.ItemOrdersBinding
import com.nicomahnic.heladerakt.domain.models.Order
import com.nicomahnic.heladerakt.ui.adapters.combos.CombosAdapter
import com.nicomahnic.heladerakt.ui.adapters.utils.Utils

class OrdersViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemOrdersBinding.bind(view)


    fun render(order: Order, position: Int, onClickListener: OrdersAdapter.ItemListener, deleteBtnStatus: Boolean){
        var btnExpandableStatus = false

        binding.tvName.text = if(order.user.name.isNotBlank()) order.user.name else "Generica"
        binding.tvDate.text = Utils.parseTimestamp(order.date)

        binding.tvComment.text = order.comment
        binding.tvComment.visibility = if(order.comment.isNotBlank()) View.VISIBLE else View.GONE

        binding.rvCombos.layoutManager = LinearLayoutManager(binding.rvCombos.context)
        val adapterCombos = CombosAdapter(order.combosList)
        binding.rvCombos.adapter = adapterCombos

        if(deleteBtnStatus){
            binding.btnDelete.visibility = View.VISIBLE
            binding.btnExpandable.visibility = View.INVISIBLE
        } else{
            binding.btnDelete.visibility = View.INVISIBLE
            binding.btnExpandable.visibility = View.VISIBLE
        }

        binding.btnExpandable.setOnClickListener {
            if(!btnExpandableStatus){
                binding.rvCombos.visibility = View.VISIBLE
                binding.btnExpandable.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                btnExpandableStatus = true
            } else {
                binding.rvCombos.visibility = View.GONE
                binding.btnExpandable.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                btnExpandableStatus = false
            }
        }

        binding.rbSelected.setOnClickListener {
            order.selected = !order.selected
            binding.rbSelected.isChecked = order.selected
            onClickListener.onSelectedItem( order, position )
        }

        binding.btnDelete.setOnClickListener {
            onClickListener.onDeleteBtnClick( order, position )
        }

        itemView.setOnClickListener {
            onClickListener.onItemClick( order, position )
        }
    }
}