package com.example.booktask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.booktask.view.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance())
                    .commitNow()
        }
    }
}