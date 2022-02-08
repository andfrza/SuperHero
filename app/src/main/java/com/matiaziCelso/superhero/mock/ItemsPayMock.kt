package com.matiaziCelso.superhero.mock

import com.matiaziCelso.superhero.models.ComicItem
import com.matiaziCelso.superhero.models.ItemsItem

class ItemsPayMock {

    fun itemsPay() : MutableList<ItemsItem>{
        return mutableListOf(
            ItemsItem(
                "Huck",
                "12",
                "Dez",
                0,
                9.50
            ),
            ItemsItem(
                "Thor",
                "19",
                "Dez",
                0,
                9.00
            ),
            ItemsItem(
                "Iron Man",
                "25",
                "Dez",
                -1,
                6.99
            ),
            ItemsItem(
                "Avengers",
                "01",
                "Jan",
                1,
                19.99
            ),
            ItemsItem(
                "Capitain Marvel",
                "12",
                "Fev",
                1,
                5.99
            ),
            ItemsItem(
                "Huck",
                "12",
                "Dez",
                0,
                9.99
            ),
            ItemsItem(
                "Huck",
                "12",
                "Dez",
                -1,
                9.99
            )
        )
    }
}