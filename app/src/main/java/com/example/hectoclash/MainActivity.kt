package com.example.hectoclash

import android.R.attr.fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.hectoclash.Gamemode.PlayOnline
import com.example.hectoclash.more.Profile

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        replaceTheFragment(home())
        bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> replaceTheFragment(home())
                R.id.item2 -> replaceTheFragment(Leaderboard())
                R.id.item3 -> replaceTheFragment(More())
            }
            true
        }

        val playButton = findViewById<CardView>(R.id.btnPlay)
        playButton.setOnClickListener {
            startActivity(Intent(this, PlayOnline::class.java))
        }
        val profileBtn = findViewById<CardView>(R.id.btnProfile)
        profileBtn.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
    fun replaceTheFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}
