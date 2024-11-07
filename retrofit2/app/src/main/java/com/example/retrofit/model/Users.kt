package com.example.materi.model

import android.provider.ContactsContract
import android.provider.ContactsContract.RawContacts.Data
import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("data")
    val `data`: List<Data>
)
