package com.matiaziCelso.superhero.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matiaziCelso.superhero.R
import com.matiaziCelso.superhero.adapter.CartItemsAdapter
import com.matiaziCelso.superhero.mock.ComicsMock
import com.matiaziCelso.superhero.mock.ComicsMock.comics

class CartFragment : Fragment(R.layout.fragment_cart) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.cart_recycle)
        recycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = CartItemsAdapter(comics())
    }

}