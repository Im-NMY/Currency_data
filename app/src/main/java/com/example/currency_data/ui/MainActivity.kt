package com.example.currency_data.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.currency_data.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bottomNavigationMenu: BottomNavigationView by lazy { findViewById(R.id.bnvBar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MainFragment())
            .commit()

        bottomNavigationMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemMain -> {
                    if (bottomNavigationMenu.selectedItemId != it.itemId) {
                        selectTab(MainFragment())
                    }
                }
                R.id.itemBookmarks -> {
                    if (bottomNavigationMenu.selectedItemId != it.itemId) {
                        selectTab(BookmarksFragment())
                    }
                }
                else -> {}
            }
            true
        }
    }

    private fun selectTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}