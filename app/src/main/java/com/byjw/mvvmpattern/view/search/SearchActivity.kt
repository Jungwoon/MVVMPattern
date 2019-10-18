package com.byjw.mvvmpattern.view.search

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.byjw.mvvmpattern.R
import com.byjw.mvvmpattern.databinding.ActivitySearchBinding
import com.byjw.mvvmpattern.view.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SearchActivity : BindingActivity<ActivitySearchBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = getViewModel()
        binding.lifecycleOwner = this

    }
}