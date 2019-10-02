package com.tregz.mvvm.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.tregz.mvvm.R
import com.tregz.mvvm.base.BaseActivity
import com.tregz.mvvm.main.auth.AuthFragment

class MainActivity : BaseActivity(), MainListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.login -> if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
                item.setIcon(R.drawable.ic_person)
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AuthFragment(), AuthFragment.getTAG())
                    .addToBackStack(AuthFragment.getTAG()).commit()
                item.setIcon(R.drawable.ic_arrow_back)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        //private val TAG: String = MainActivity::class.java.simpleName
    }
}
