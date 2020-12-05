package ca.qc.cstj.spaceexplorer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import ca.qc.cstj.spaceexplorer.PlanetsFragmentDirections
import ca.qc.cstj.spaceexplorer.R
import ca.qc.cstj.spaceexplorer.databinding.ViewholderPlanetBinding
import ca.qc.cstj.spaceexplorer.models.Planet
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.NumberFormat
import java.util.*

class PlanetRecyclerViewAdapter(var planets: List<Planet> = listOf()) : RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>() {

    private lateinit var circularProgressDrawable: CircularProgressDrawable

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_planet, parent, false)

        circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetRecyclerViewAdapter.ViewHolder, position: Int) {
        val planet = planets[position]
        holder.bind(planet)
    }

    override fun getItemCount(): Int = planets.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //BINDING Ajout ici
        private val binding = ViewholderPlanetBinding.bind(view)
        //TODO: Gestion de l'interface graphique d'une carte pour une planète
        //Afficher son nom et sa température
        private val txvPlanetName: TextView = binding.txvPlanetName
        private val txvTemperature: TextView = binding.txvTemperature
        private val imgIconPlanet: ImageView = binding.imgIconPlanet

        fun bind(planet: Planet) {
            txvPlanetName.text = planet.name
            txvTemperature.text = NumberFormat.getInstance(Locale.CANADA_FRENCH).format(planet.temperature)

            val requestOptions = RequestOptions().placeholder(circularProgressDrawable).error(R.drawable.logo)

            Glide.with(binding.root.context) //Autre bibliothèque Picasso
                    .applyDefaultRequestOptions(requestOptions)
                    .load(planet.icon)
                    .into(imgIconPlanet)

            binding.root.setOnClickListener {
                Toast.makeText(it.context, planet.name, Toast.LENGTH_SHORT).show()

                //val direction = PlanetsFragmentDirections.actionPlanetsFragmentToDetailPlanetFragment(planet.href, null)
                val direction = PlanetsFragmentDirections.actionPlanetsFragmentToDetailPlanetFragmentWithPlanet(planet.href, planet)

                it.findNavController().navigate(direction)
            }

        }

    }

}