package com.kelompok6.kelompokenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kelompok6.R
import com.kelompok6.databinding.ActivityBottomNavBinding

class Bottom_nav : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())

        binding.bottonNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> replaceFragment(Home())
                R.id.page_2 -> replaceFragment(Favorite())
                R.id.page_3 -> replaceFragment(History())
                R.id.page_4-> replaceFragment(Profile())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}