package com.example.mvvm_coroutine_retro_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpfragment()
    }

    private fun setUpfragment(){
        val fragment = RecyclerListFragment.newInstance()
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTrasaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTrasaction.replace(android.R.id.content,fragment)
        fragmentTrasaction.commit()

    }
}