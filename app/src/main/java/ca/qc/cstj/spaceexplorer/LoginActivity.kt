package ca.qc.cstj.spaceexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ca.qc.cstj.spaceexplorer.databinding.ActivityBikiniBottomBinding
import ca.qc.cstj.spaceexplorer.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        const val GOOD_PASSWORD = "123456"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Afficher un message dans le TextView
        //Ancienne manière de faire avant Kotlin
        //val txtMessage = findViewById<TextView>(R.id.txvMessage) //val = const js et var = let js
        //txtMessage.text = "Message du code-behind"

        //txvMessage.text = "Message du code-behind"

    }

    fun btnConnectionClick(view:View?) {

        //Toast.makeText(this, "Bonjour du bouton", Toast.LENGTH_LONG).show()
        val username = binding.edtUsername.editableText
        val password = binding.edtPassword.editableText

        //Snackbar.make(ctlContent,"Bonjour d'un Snackbar chez ${username} et mot de passe ${password}",Snackbar.LENGTH_LONG).show()

        if(password.toString() == GOOD_PASSWORD && username.isNotBlank()) {
            //TODO: Changer d'activity
            //val intent = PlanetsActivity.createIntent(this,username.toString())
            val intent = BikiniBottomActivity.newIntent(this,username.toString())
            startActivity(intent)
        } else {
            Toast.makeText(this, "Mauvais mot de passe", Toast.LENGTH_LONG).show()
        }

    }
}