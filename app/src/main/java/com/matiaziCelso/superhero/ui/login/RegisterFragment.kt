package com.matiaziCelso.superhero.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.matiaziCelso.superhero.R


class RegisterFragment : Fragment(R.layout.fragment_register) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val returnLogin: TextView = view.findViewById(R.id.return_login)

        returnLogin.setOnClickListener {
           activity?.onBackPressed()
        }
    }


}