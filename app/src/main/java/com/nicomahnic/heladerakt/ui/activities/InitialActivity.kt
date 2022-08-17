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

        binding.btnBegin.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        initialVM.insertDeliveries(deliveryList)
        initialVM.insertTasteOptions(tasteList)
        initialVM.insertIceCreamOptions(iceCreamOptionList)

    }

    companion object {
        val iceCreamOptionList = mutableListOf(
            IceCreamOption("1 kg" ),
            IceCreamOption("1/2 kg"),
            IceCreamOption("1/4 kg"),
            IceCreamOption("Cucurucho"),
        )

        val tasteList = mutableListOf(
            TasteOption("Limon"),
            TasteOption("Frutilla"),
            TasteOption("Naranja"),
            TasteOption("Frambuesa"),
            TasteOption("Ananá"),
            TasteOption("Durazno"),
            TasteOption("Sandia"),
            TasteOption("Pomelo"),
            TasteOption("Crema del Cielo"),
            TasteOption("Crema Americana"),
            TasteOption("Tramontana"),
            TasteOption("Vainilla"),
        )

        val deliveryList = mutableListOf(
            Delivery("Boedo", "Boedo 123", "+34 610087495"),
        )

    }

}