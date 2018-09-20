package id.smartdev.footballmatchschedule.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.smartdev.footballmatchschedule.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_prev_match -> {
                    loadLastMatchFragment(savedInstanceState)
                }
                R.id.nav_next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }
            }
            true
        }
        navigation.selectedItemId = R.id.nav_prev_match
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_container, LastMatchFragment(), LastMatchFragment::class.simpleName)
                    .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_container, NextMatchFragment(), NextMatchFragment::class.simpleName)
                    .commit()
        }
    }
}
