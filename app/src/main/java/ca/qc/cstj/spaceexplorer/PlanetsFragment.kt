package ca.qc.cstj.spaceexplorer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.spaceexplorer.adapters.PlanetRecyclerViewAdapter
import ca.qc.cstj.spaceexplorer.helpers.TopSpacingItemDecoration
import ca.qc.cstj.spaceexplorer.models.Planet
import kotlinx.android.synthetic.main.fragment_planets.*
import kotlin.random.Random

class PlanetsFragment : Fragment() {

    private lateinit var planetRecyclerViewAdapter : PlanetRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topSpacingItemDecoration = TopSpacingItemDecoration(30)

        //TODO: Afficher les planètes dans le Recycler View
        planetRecyclerViewAdapter = PlanetRecyclerViewAdapter(createPlanet())

        rcvPlanets.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = planetRecyclerViewAdapter
            addItemDecoration(topSpacingItemDecoration)
        }
    }

    private fun createPlanet() : List<Planet> {
        val planets = mutableListOf<Planet>()

        val numberToGenerate = Random.nextInt(0,21)

        for(i in 0..numberToGenerate) {
            val newPlanet = Planet("Planet $i", Random.nextDouble(20.0, 50.0), Random.nextInt(1,25).toString())
            planets.add(newPlanet)
        }

        return planets

    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            PlanetsFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}