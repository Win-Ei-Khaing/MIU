package com.miu.viewmodeldemo

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var countA = 0
    var countB = 0
    fun updateCountA(){
        ++countA
    }
    fun updateCountB(){
        ++countB
    }
}