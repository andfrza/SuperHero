package com.matiaziCelso.superhero.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class ComicItem(
    val title: String,
    val image: String,
    val description: String,
    val value: Double,
    val isFavorite: Boolean,
    val characters: List<CharacterItem>,
    val more: List<ComicItem>
): Parcelable



@Parcelize
class CharacterItem(
    val name: String,
    val image: String,
    val description: String,
    val comics: List<ComicItem>
): Parcelable