package com.ariemay.starterjetpack.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    // TODO: Implement the ViewModel
    val newData = MutableLiveData<String>()
    val data: LiveData<String>
        /*Getter*/
        get() = newData
    init {
        newData.value = "Hello, dunia!"
    }

}