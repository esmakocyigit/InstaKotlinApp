package com.example.instakotlinapp.Login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.instakotlinapp.R
import com.example.instakotlinapp.utils.EventbusDataEvents
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class TelefonKoduGirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_telefon_kodu_gir, container, false)
    }
    @Subscribe (sticky = true)
    internal fun onTelefonNoEvent(telefonNumarasi :EventbusDataEvents.TelefonNoGonder){
        var gelenTelNo=telefonNumarasi.telNo
        Log.e("esma","gelen tel no"+gelenTelNo)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBus.getDefault().register(this)

    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }
}
