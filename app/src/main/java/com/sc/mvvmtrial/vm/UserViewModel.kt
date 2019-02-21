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
        name.value = "Start"
    }
}

fun CoroutineScope.launchUpdateSomeShit(vm: UserViewModel) {
    launch {
        var counter = 0
        while (true) {
            Log.i("[launchUpdateSomeShit]", "Iteration $counter")
            delay(2000)
            vm.name.value = counter.toString()
            ++counter
        }
    }
}