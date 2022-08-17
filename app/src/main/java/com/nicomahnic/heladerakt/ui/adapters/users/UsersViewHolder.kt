package com.nicomahnic.heladerakt.ui.adapters.users

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.databinding.ItemUsersBinding
import com.nicomahnic.heladerakt.domain.models.User
import com.nicomahnic.heladerakt.ui.adapters.utils.Utils

class UsersViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemUsersBinding.bind(view)

    fun render(user: User, onClickListener: UsersAdapter.ItemListener){
        binding.tvName.text = user.name
        binding.tvDate.text = Utils.parseTimestamp(user.date)
        binding.tvAddress.text = user.address

        if(user.selected)
            binding.ivProfile.setImageResource(R.drawable.ic_baseline_emoji_people_24)
        else
            binding.ivProfile.setImageResource(R.drawable.ic_baseline_accessibility_new_24)

        itemView.setOnClickListener {
            user.selected = true
            binding.ivProfile.setImageResource(R.drawable.ic_baseline_accessibility_new_24)
            onClickListener.onBtnClick( user )
        }
    }
}