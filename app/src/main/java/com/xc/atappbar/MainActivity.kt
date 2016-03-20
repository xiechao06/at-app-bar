package com.xc.atappbar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.support.v7.widget.ShareActionProvider
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

fun toast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(my_toolbar as Toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu!!.findItem(R.id.action_search);
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView;

        MenuItemCompat.setOnActionExpandListener(searchItem, object: MenuItemCompat.OnActionExpandListener {

            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                toast(this@MainActivity, "search view expand")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                toast(this@MainActivity, "search view collapse")
                return true
            }
        })

        val shareItem = menu!!.findItem(R.id.action_share)
        val shareActionProvider = MenuItemCompat.getActionProvider(shareItem) as ShareActionProvider
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareActionProvider.setShareIntent(shareIntent)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_settings -> {
                toast(this, "click settings")
                return true
            }
            R.id.action_favorite -> {
                toast(this, "click favorite")
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }
}
