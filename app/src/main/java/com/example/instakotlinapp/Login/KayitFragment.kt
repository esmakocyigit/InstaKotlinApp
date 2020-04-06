package com.example.instakotlinapp.Login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.instakotlinapp.R
import com.example.instakotlinapp.utils.EventbusDataEvents
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class KayitFragment : Fragment() {

    var telNo=""
    var verificationID=""
    var gelenKod=""
    var gelenEmail=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_kayit, container, false)
    }

    @Subscribe(sticky = true)
    internal fun onKayitEvent(kayitBilgileri : EventbusDataEvents.KayitBilgileriniGonder){

        if(kayitBilgileri.emailKayit==true){
             gelenEmail=kayitBilgileri.email!!

             Toast.makeText(activity,"Gelen email :" +gelenEmail,Toast.LENGTH_SHORT).show()
             Log.e("esma","gelen tel no"+gelenEmail)
        }else{
            telNo=kayitBilgileri.telNo!!
            verificationID =kayitBilgileri.verificationID!!
            gelenKod=kayitBilgileri.code!!

            Toast.makeText(activity,"Gelen kod :" + gelenKod+"VerificationID:"+verificationID,Toast.LENGTH_SHORT).show()

        }


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
