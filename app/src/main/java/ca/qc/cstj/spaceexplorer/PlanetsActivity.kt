package ca.qc.cstj.spaceexplorer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_planets.*

class PlanetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planets)

        val username = intent.getStringExtra(INTENT_USERNAME)
        Toast.makeText(this,username, Toast.LENGTH_LONG).show()
        txvBonjour.text = resources.getString(R.string.msgWelcome, username)

    }

    companion object {

        private const val INTENT_USERNAME = "username"

        fun createIntent(context: Context, username:String): Intent {
            val intent = Intent(context, PlanetsActivity::class.java)
            intent.putExtra(INTENT_USERNAME, username)

            return intent
        }
    }
}