package ca.qc.cstj.spaceexplorer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.spaceexplorer.adapters.PlanetRecyclerViewAdapter
import ca.qc.cstj.spaceexplorer.databinding.ActivityLoginBinding
import ca.qc.cstj.spaceexplorer.databinding.ActivityPlanetsBinding
import ca.qc.cstj.spaceexplorer.helpers.TopSpacingItemDecoration
import ca.qc.cstj.spaceexplorer.models.Planet
import kotlin.random.Random

class PlanetsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlanetsBinding

    private lateinit var planetRecyclerViewAdapter : PlanetRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(INTENT_USERNAME)
        Toast.makeText(this,username, Toast.LENGTH_LONG).show()
        binding.txvBonjour.text = resources.getString(R.string.msgWelcome, username)

        val topSpacingItemDecoration = TopSpacingItemDecoration(30)

        //TODO: Afficher les planètes dans le Recycler View
        planetRecyclerViewAdapter = PlanetRecyclerViewAdapter(createPlanet())

        /*with(rcvPlanets) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = planetRecyclerViewAdapter
            addItemDecoration(topSpacingItemDecoration)
        }*/

        binding.rcvPlanets.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = planetRecyclerViewAdapter
            addItemDecoration(topSpacingItemDecoration)
        }
    }

    private fun createPlanet() : List<Planet> {
        val planets = mutableListOf<Planet>()

        val numberToGenerate = Random.nextInt(0,21)

        for(i in 0..numberToGenerate) {
            val newPlanet = Planet("Planet $i", Random.nextDouble(20.0, 50.0), Random.nextInt(1,25).toString(),"")
            planets.add(newPlanet)
        }

        return planets

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