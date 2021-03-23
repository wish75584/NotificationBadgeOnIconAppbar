package com.androidbatch.notificationbadgeoniconappbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    var textCartItemCount: TextView? = null
    var mCartItemCount = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        var menuitem: MenuItem? = menu?.findItem(R.id.action_cart)

        val actionView: View? = menuitem?.actionView

        textCartItemCount = actionView?.findViewById(R.id.cart_badge) as TextView
        setupBadge();

        actionView.setOnClickListener {
            if (menuitem != null) {
                onOptionsItemSelected(menuitem)
            };
        }

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_cart -> {
                Toast.makeText(this, "action_cart", Toast.LENGTH_LONG).show()

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBadge() {

        if (textCartItemCount != null) {
            textCartItemCount!!.setVisibility(View.VISIBLE)

        } else {
            textCartItemCount!!.text = (Math.min(mCartItemCount, 99).toString())
            if (textCartItemCount!!.getVisibility() !== View.VISIBLE) {
                textCartItemCount!!.setVisibility(View.VISIBLE)
            }
        }
    }
}


