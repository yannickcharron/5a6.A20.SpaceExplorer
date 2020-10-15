package ca.qc.cstj.spaceexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Afficher un message dans le TextView
        //Ancienne manière de faire avant Kotlin
        //val txtMessage = findViewById<TextView>(R.id.txvMessage) //val = const js et var = let js
        //txtMessage.text = "Message du code-behind"

        //txvMessage.text = "Message du code-behind"

    }

    fun btnConnectionClick(view: View?) {

        Toast.makeText(this, "Bonjour du bouton", Toast.LENGTH_LONG).show()

    }
}