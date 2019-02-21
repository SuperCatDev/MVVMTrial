package com.sc.mvvmtrial.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sc.mvvmtrial.R
import com.sc.mvvmtrial.databinding.ActivityMainBinding
import com.sc.mvvmtrial.vm.UserViewModel
import com.sc.mvvmtrial.vm.getViewModel
import com.sc.mvvmtrial.vm.launchUpdateSomeShit

const val USER_ID = "User_ID"

class MainActivity : ScopedActivity() {
    private val vm: UserViewModel by lazy {
        getViewModel { UserViewModel(intent.getIntExtra(USER_ID, -1)) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            viewModel = vm
            lifecycleOwner = this@MainActivity
        }

        launchUpdateSomeShit(vm)
    }
}
