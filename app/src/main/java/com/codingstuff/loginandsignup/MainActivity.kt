package com.codingstuff.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "View Options"
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_navigation -> {
                // Switch to NavigationActivity
                val intent = Intent(this, NavigationActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_search_history -> {
                // Switch to HistoryActivity
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_faq -> {
                // Switch to FAQActivity
                val intent = Intent(this, FAQActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_sign_out -> {
                // Sign out and switch to SignInActivity
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish() // close the MainActivity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
