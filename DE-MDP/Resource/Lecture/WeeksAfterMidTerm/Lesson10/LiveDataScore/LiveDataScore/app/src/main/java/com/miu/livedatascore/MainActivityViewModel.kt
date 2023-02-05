package com.miu.livedatascore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var countA = MutableLiveData<Int>()
    var countB = MutableLiveData<Int>()
    init {
        countA.value = 0
        countB.value = 0
    }
   fun updateCountA(){
       countA.value = (countA.value)?.plus(1)
    }
    fun updateCountB(){
        countB.value = (countB.value)?.plus(1)
    }
}