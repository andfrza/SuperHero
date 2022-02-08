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
import com.matiaziCelso.superhero.adapter.CharactersAdapter
import com.matiaziCelso.superhero.adapter.HomeAdapter
import com.matiaziCelso.superhero.mock.CharactersMock
import com.matiaziCelso.superhero.mock.ComicsMock
import com.matiaziCelso.superhero.models.CharacterItem
import com.matiaziCelso.superhero.models.ComicItem

class ComicDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_detail)
        supportActionBar?.hide()

        val extras : Bundle? = intent.extras
        val comicItem: ComicItem? = extras?.getParcelable<ComicItem>("comicItem")

        val banner = findViewById<ImageView>(R.id.comic_detail_banner)
        val backBtn = findViewById<ImageView>(R.id.comic_detail_back_btn)
        val cover = findViewById<ImageView>(R.id.img_item_detail)
        val title = findViewById<TextView>(R.id.comic_detail_title)
        val price = findViewById<TextView>(R.id.comic_detail_price)
        val description = findViewById<TextView>(R.id.comic_description)

        backBtn.setOnClickListener {
            onBackPressed()
        }

        //Glide.with(banner.context).load(comicItem?.image).into(banner)
        Glide.with(cover.context).load(comicItem?.image).into(cover)
        title.text = comicItem?.title
        price.text = "R$ " + comicItem?.value.toString()
        description.text = comicItem?.description

        val recycler = findViewById<RecyclerView>(R.id.comic_mais_recycler)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = HomeAdapter(ComicsMock.comics()){
            sendComicToDetail(it)
        }


        val recyclerCharacters = findViewById<RecyclerView>(R.id.comic_personagens_recycler)

        val characters =  mutableListOf(
            CharactersMock.ironMan(),
            CharactersMock.thor(),
            CharactersMock.huck(),
            CharactersMock.captainAmerica(),
        )

        val randomCharacters = characters.shuffled()
        recyclerCharacters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerCharacters.adapter = CharactersAdapter(randomCharacters as MutableList<CharacterItem>){
            sendCharacterToDetail(it)
        }


    }


    private fun sendComicToDetail(item: ComicItem){
        val intent = Intent(this, ComicDetailActivity::class.java)
        intent.putExtra("comicItem", item)
        startActivity(intent)
    }


    private fun sendCharacterToDetail(item: CharacterItem){
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra("characterItem", item)
        startActivity(intent)
    }
}