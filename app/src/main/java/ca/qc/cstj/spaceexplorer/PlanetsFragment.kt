package ca.qc.cstj.spaceexplorer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.spaceexplorer.adapters.PlanetRecyclerViewAdapter
import ca.qc.cstj.spaceexplorer.databinding.FragmentHomeBinding
import ca.qc.cstj.spaceexplorer.databinding.FragmentPlanetsBinding
import ca.qc.cstj.spaceexplorer.helpers.RepositoryResult
import ca.qc.cstj.spaceexplorer.helpers.TopSpacingItemDecoration
import ca.qc.cstj.spaceexplorer.models.Planet
import ca.qc.cstj.spaceexplorer.repositories.PlanetRepository
import kotlinx.coroutines.launch
import kotlin.random.Random

class PlanetsFragment : Fragment() {

    private var _binding : FragmentPlanetsBinding? =  null
    private val binding get() = _binding!!

    private lateinit var planetRecyclerViewAdapter : PlanetRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topSpacingItemDecoration = TopSpacingItemDecoration(30)

        //Appel à notre repository pour récupérer les planètes

        val username = PlanetsFragmentArgs.fromBundle(requireActivity().intent.extras!!).username
        binding.txvBonjour.text = resources.getString(R.string.msgWelcome, username)

        //TODO: Afficher les planètes dans le Recycler View
        planetRecyclerViewAdapter = PlanetRecyclerViewAdapter()

        binding.rcvPlanets.apply {
            //layoutManager = GridLayoutManager(this.context,2)
            layoutManager = LinearLayoutManager(this.context)
            adapter = planetRecyclerViewAdapter
            addItemDecoration(topSpacingItemDecoration)
        }

        lifecycleScope.launch {

            when(val result = PlanetRepository.getPlanets()) {
                is RepositoryResult.Success -> {
                    planetRecyclerViewAdapter.planets = result.data
                    binding.rcvPlanets.adapter!!.notifyDataSetChanged()
                }
                is RepositoryResult.Error -> {
                    Toast.makeText(this@PlanetsFragment.context, result.exception.message,Toast.LENGTH_LONG).show()
                }
            }
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

        fun newInstance() =
            PlanetsFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}