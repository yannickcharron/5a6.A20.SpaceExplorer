package ca.qc.cstj.spaceexplorer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ca.qc.cstj.spaceexplorer.databinding.ActivityBikiniBottomBinding

class BikiniBottomActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityBikiniBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBikiniBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.planetsFragment, R.id.settingsFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bnvNavigation.setupWithNavController(navController)

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