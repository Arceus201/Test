package com.example.test.screen.tab1

import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import com.example.movies.utlis.base.BaseFragment
import com.example.test.databinding.FragmentTab1Binding
import com.example.test.utils.Constant

class Tab1Fragment : BaseFragment<FragmentTab1Binding>(
    FragmentTab1Binding::inflate
) {


    override fun initView(savedInstanceState: Bundle?) {
        configureWebViewSettings()
        binding.webViewGoogle.loadUrl(Constant.URL_GOOGLE)
    }

    override fun initData() {

    }

    override fun handleEvent() {

    }


    fun configureWebViewSettings() {
        val settings = binding.webViewGoogle.settings

        // Enable JavaScript
        settings.javaScriptEnabled = true

        // Enable zoom control
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        // Enable links outside of the app to open in the default browser
        binding.webViewGoogle.webViewClient = WebViewClient()
    }

}