package com.sc.mvvmtrial.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewModel(var userId: Int) : ViewModel() {
    var name = MutableLiveData<String>()

    init {
        // Here you could use the ID to get the user info from the DB or remote server
        name.value = "Felipe"
    }
}

fun CoroutineScope.launchUpdateSomeShit(vm: UserViewModel) {
    launch {
        var counter = 0
        while (true) {
            Log.e("CoroutineScope", "Iteration $counter")
            delay(2000)
            vm.name.value = counter.toString()
            ++counter
        }
    }
}