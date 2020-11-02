package ca.qc.cstj.spaceexplorer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.spaceexplorer.adapters.PlanetRecyclerViewAdapter
import ca.qc.cstj.spaceexplorer.helpers.TopSpacingItemDecoration
import ca.qc.cstj.spaceexplorer.models.Planet
import kotlinx.android.synthetic.main.activity_planets.*
import kotlin.random.Random

class PlanetsActivity : AppCompatActivity() {

    private lateinit var planetRecyclerViewAdapter : PlanetRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planets)

        val username = intent.getStringExtra(INTENT_USERNAME)
        Toast.makeText(this,username, Toast.LENGTH_LONG).show()
        txvBonjour.text = resources.getString(R.string.msgWelcome, username)

        val topSpacingItemDecoration = TopSpacingItemDecoration(30)

        //TODO: Afficher les planètes dans le Recycler View
        planetRecyclerViewAdapter = PlanetRecyclerViewAdapter(createPlanet())

        /*with(rcvPlanets) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = planetRecyclerViewAdapter
            addItemDecoration(topSpacingItemDecoration)
        }*/

        rcvPlanets.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = planetRecyclerViewAdapter
            addItemDecoration(topSpacingItemDecoration)
        }
    }

    fun createPlanet() : List<Planet> {
        val planets = mutableListOf<Planet>()

        val numberToGenerate = Random.nextInt(0,21)

        for(i in 0..numberToGenerate) {
            val newPlanet = Planet("Planet $i", Random.nextDouble(20.0, 50.0))
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