package com.example.test.screen.tab2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import com.example.movies.utlis.base.BaseFragment
import com.example.test.databinding.FragmentTab2Binding
import com.example.test.screen.main.MainActivity
import com.example.test.utils.Constant

class Tab2Fragment : BaseFragment<FragmentTab2Binding>(
    FragmentTab2Binding::inflate
) {
    override fun initView(savedInstanceState: Bundle?) {
        configureWebViewSettings()
        binding.webViewStack.loadUrl(Constant.URL_STACK_OVER_FLOW)

    }

    override fun initData() {

    }

    override fun handleEvent() {

    }




    fun configureWebViewSettings() {
        val settings = binding.webViewStack.settings

        // Enable JavaScript
        settings.javaScriptEnabled = true

        // Enable zoom control
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        // Enable links outside of the app to open in the default browser
        binding.webViewStack.webViewClient = WebViewClient()
    }

}