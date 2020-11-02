package ca.qc.cstj.spaceexplorer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_bikini_bottom.*

class BikiniBottomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bikini_bottom)

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.planetsFragment, R.id.settingsFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bnvNavigation.setupWithNavController(navController)

    }


    companion object {
        private const val INTENT_USERNAME = "username"

        fun newIntent(context: Context, username: String): Intent {
            val intent = Intent(context, BikiniBottomActivity::class.java)
            intent.putExtra(INTENT_USERNAME, username)
            return intent
        }

    }
}