package com.example.zap_clone.view.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.zap_clone.R
import com.example.zap_clone.model.adapter.SectionsPagerAdapter
import com.example.zap_clone.databinding.ActivityMainBinding
import com.example.zap_clone.model.User

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)
        supportActionBar?.title = "WhatsApp"

        val userInfo = intent.getParcelableExtra<User>(KEY_USER) ?: throw IllegalAccessException("Usuario não encontrado")

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, userInfo)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_main_newGroup -> Toast.makeText(this, "Novo grupo", Toast.LENGTH_LONG).show()
            R.id.menu_main_settings -> Toast.makeText(this, "Configurações", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val KEY_USER = "key_user"
    }

}