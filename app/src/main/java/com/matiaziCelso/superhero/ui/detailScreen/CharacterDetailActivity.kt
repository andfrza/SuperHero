package com.matiaziCelso.superhero.ui.detailScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matiaziCelso.superhero.R
import com.matiaziCelso.superhero.adapter.HomeAdapter
import com.matiaziCelso.superhero.mock.ComicsMock
import com.matiaziCelso.superhero.models.CharacterItem
import com.matiaziCelso.superhero.models.ComicItem

class CharacterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        supportActionBar?.hide()

        val extras : Bundle? = intent.extras
        val characterItem: CharacterItem? = extras?.getParcelable<CharacterItem>("characterItem")

        val banner = findViewById<ImageView>(R.id.character_detail_banner)
        val backBtn = findViewById<ImageView>(R.id.character_detail_back_btn)
        val name = findViewById<TextView>(R.id.character_detail_title)
        val description = findViewById<TextView>(R.id.character_description)


        backBtn.setOnClickListener {
            onBackPressed()
        }


        Glide.with(banner.context).load(characterItem?.image).into(banner)
        name.text = characterItem?.name
        description.text = characterItem?.description

        val recycler = findViewById<RecyclerView>(R.id.character_mais_recycler)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = HomeAdapter(ComicsMock.comics()){
            sendToComicDetail(it)
        }
    }

    private fun sendToComicDetail(item: ComicItem){
        val intent = Intent(this, ComicDetailActivity::class.java)
        intent.putExtra("comicItem", item)
        startActivity(intent)
    }
}