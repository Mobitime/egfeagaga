package com.example.egfeagaga

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var gridView: GridView
    private val websites = listOf(
        WebSite("VK", "https://vk.com/", R.drawable.freevk),
        WebSite("Google", "https://www.google.com", R.drawable.freeg)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Мобильный браузер"

        gridView = findViewById(R.id.gridView)
        gridView.adapter = WebSiteAdapter(this, websites)

        gridView.setOnItemClickListener { _, _, position, _ ->
            val website = websites[position]
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("url", website.url)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}