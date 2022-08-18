package com.nicomahnic.heladerakt.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nicomahnic.heladerakt.databinding.ActivityInitialBinding
import com.nicomahnic.heladerakt.domain.models.Delivery
import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.domain.models.TasteOption
import com.nicomahnic.heladerakt.ui.viewmodels.InitialVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInitialBinding

    private val initialVM: InitialVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInitialBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initialVM.getData()

        binding.btnBegin.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

}