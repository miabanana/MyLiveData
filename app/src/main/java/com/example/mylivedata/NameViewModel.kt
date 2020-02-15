package com.example.mylivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Serializable

class NameViewModel : ViewModel(), Serializable {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}