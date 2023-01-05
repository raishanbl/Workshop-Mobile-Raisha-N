package com.codelabs.aktorkoreaselatanfavorite

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Actors(
    var name : String = "",
    var agency : String = "",
    var tittlemovie : String = "",
    var detail : String = "",
    var photo : Int = 0,
) : Parcelable
