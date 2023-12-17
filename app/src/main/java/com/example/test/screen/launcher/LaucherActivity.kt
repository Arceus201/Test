package com.example.test.screen.launcher

import android.content.Intent
import com.example.movies.utlis.base.BaseActivity
import com.example.test.databinding.ActivityLaucherBinding
import com.example.test.screen.main.MainActivity
import com.example.test.utils.Constant.TIME_DELAY_START_APP
import com.example.test.utils.Constant.handler

class LaucherActivity: BaseActivity<ActivityLaucherBinding>(ActivityLaucherBinding::inflate) {
    override fun initView() {
        handler.postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
        }, TIME_DELAY_START_APP)
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun handleEvent() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}