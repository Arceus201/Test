package com.example.test.screen.main


import android.os.Bundle
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
    var bundleget: Bundle?=null
    override fun initView() {
        switchFragment(Tab1Fragment(), TAG_GOOGLE)
    }

    override fun initData() {
        //TODO("Not yet implemented")
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
                        switchFragment(Tab1Fragment(), TAG_GOOGLE)
                        return@setOnNavigationItemSelectedListener true
                    }
                    com.example.test.R.id.menu_stack_over_flow -> {
                        switchFragment(Tab2Fragment(), TAG_STACK_OVER_FLOW)
                        return@setOnNavigationItemSelectedListener true
                    }
                    com.example.test.R.id.menu_permission -> {
                        switchFragment(Tab3Fragment(), TAG_PERMISSION)
                        return@setOnNavigationItemSelectedListener true
                    }
                    com.example.test.R.id.menu_person -> {
                        switchFragment(Tab4Fragment(), TAG_PERSON)
                        return@setOnNavigationItemSelectedListener true
                    }

                    else -> return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }

    fun switchFragment(fragment: Fragment, tag: String) {
        if (supportFragmentManager.findFragmentByTag(tag) != null) return
        supportFragmentManager
            .beginTransaction()
            .replace(com.example.test.R.id.frame_container, fragment,tag)
            .commit()
    }
    fun getBundle(): Bundle{
        bundleget = Bundle()
        return bundleget as Bundle
    }

    companion object {
        const val TAG_GOOGLE = "google.com"
        const val TAG_STACK_OVER_FLOW = "stack_over_flow.com"
        const val TAG_PERMISSION = "permission"
        const val TAG_PERSON = "person"
    }
}