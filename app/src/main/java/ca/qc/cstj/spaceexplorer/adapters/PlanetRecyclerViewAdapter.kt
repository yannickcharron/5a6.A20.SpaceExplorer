package ca.qc.cstj.spaceexplorer.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.spaceexplorer.models.Planet

class PlanetRecyclerViewAdapter(private val planets: List<Planet>) : RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetRecyclerViewAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PlanetRecyclerViewAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = planets.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //TODO: Gestion de l'interface graphique d'une carte pour une planète
        //Afficher son nom et sa température

    }

}