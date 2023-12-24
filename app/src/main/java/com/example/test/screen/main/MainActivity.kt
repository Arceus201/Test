package com.example.test.screen.main


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.movies.utlis.base.BaseActivity
import com.example.test.databinding.ActivityMainBinding
import com.example.test.screen.tab1.Tab1Fragment
import com.example.test.screen.tab2.Tab2Fragment
import com.example.test.screen.tab3.Tab3Fragment
import com.example.test.screen.tab4.Tab4Fragment


class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {
    private val fragment1 = Tab1Fragment()
    private val fragment2 = Tab2Fragment()
    private val fragment3 = Tab3Fragment()
    private val fragment4 = Tab4Fragment()
    private val fragmentList = listOf(fragment1, fragment2, fragment3, fragment4)
    private val tagList = listOf(TAG_GOOGLE, TAG_STACK_OVER_FLOW, TAG_PERMISSION, TAG_PERSON)
    override fun initView() {
        addFragment(Tab1Fragment(), TAG_GOOGLE)
    }

    override fun initData() {
        initFragment()
    }

    private fun initFragment() {
        Log.e("init Fragment:", "init")
        var count: Int = 0
        for (fragment in fragmentList) {
            addFragment(fragment, tagList.get(count++))
        }
        showFragment(fragment1)
    }

    override fun handleEvent() {
        binding.apply {
            nestedScroll.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                val threshold = 200
                // Khi cuộn xuống, ẩn Bottom Navigation
                if (scrollY > threshold && bottomNavigation.isShown) {
                    bottomNavigation.visibility = View.GONE
                }
                // Khi cuộn lên và NestedScrollView ở đầu trang, hiện Bottom Navigation
                else if (scrollY <= threshold && !bottomNavigation.isShown) {
                    bottomNavigation.visibility = View.VISIBLE
                }
            }

            bottomNavigation.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    com.example.test.R.id.menu_google -> {
                        showHideFragment(fragment1)
                        return@setOnNavigationItemSelectedListener true
                    }
                    com.example.test.R.id.menu_stack_over_flow -> {
                        showHideFragment(fragment2)
                        return@setOnNavigationItemSelectedListener true
                    }
                    com.example.test.R.id.menu_permission -> {
                        showHideFragment(fragment3)
                        return@setOnNavigationItemSelectedListener true
                    }
                    com.example.test.R.id.menu_person -> {
                        showHideFragment(fragment4)
                        return@setOnNavigationItemSelectedListener true
                    }

                    else -> return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }
    fun showHideFragment(fragmentShow: Fragment) {
        for (fragment in fragmentList) {
            if (fragment == fragmentShow) {
                showFragment(fragment)
            }else{
                hideFragment(fragment)
            }
        }
    }

    fun addFragment(fragment: Fragment, tag: String) {
        if (supportFragmentManager.findFragmentByTag(tag) != null) return
        supportFragmentManager
            .beginTransaction()
            .add(com.example.test.R.id.frame_container, fragment,tag)
            .hide(fragment)
            .commit()
    }

    // Hàm ẩn hiện fragment

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .show(fragment)
            .commit()
    }

    fun hideFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .hide(fragment)
            .commit()
    }



    companion object {
        const val TAG_GOOGLE = "google.com"
        const val TAG_STACK_OVER_FLOW = "stack_over_flow.com"
        const val TAG_PERMISSION = "permission"
        const val TAG_PERSON = "person"
    }
}