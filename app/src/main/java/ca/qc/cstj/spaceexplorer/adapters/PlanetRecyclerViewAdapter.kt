package ca.qc.cstj.spaceexplorer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.spaceexplorer.R
import ca.qc.cstj.spaceexplorer.models.Planet
import kotlinx.android.synthetic.main.viewholder_planet.view.*

class PlanetRecyclerViewAdapter(private val planets: List<Planet>) : RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_planet, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetRecyclerViewAdapter.ViewHolder, position: Int) {
        val planet = planets[position]
        holder.txvPlanetName.text = planet.name
        holder.txvTemperature.text = planet.temperature.toString()

    }

    override fun getItemCount(): Int = planets.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //TODO: Gestion de l'interface graphique d'une carte pour une planète
        //Afficher son nom et sa température
        val txvPlanetName: TextView = view.txvPlanetName
        val txvTemperature : TextView = view.txvTemperature

    }

}