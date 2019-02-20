package com.sc.mvvmtrial.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.sc.mvvmtrial.R
import com.sc.mvvmtrial.databinding.ActivityMainBinding
import com.sc.mvvmtrial.vm.UserViewModel
import com.sc.mvvmtrial.vm.getViewModel
import com.sc.mvvmtrial.vm.launchUpdateSomeShit
import kotlinx.android.synthetic.main.activity_main.*

const val USER_ID = "User_ID"

class MainActivity : ScopedActivity(), LifecycleOwner {
    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    private val vm: UserViewModel by lazy {
        getViewModel { UserViewModel(intent.getIntExtra(USER_ID, -1)) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            viewModel = vm
            lifecycleOwner = this@MainActivity
        }

        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            textView.text = newName
        }

      //  vm.name.observe(this, nameObserver)

        launchUpdateSomeShit(vm)
    }
}