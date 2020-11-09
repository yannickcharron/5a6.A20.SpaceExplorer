package ca.qc.cstj.spaceexplorer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs

class DetailPlanetFragment : Fragment() {

    private val args: DetailPlanetFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_planet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(this.context, args.planet!!.name, Toast.LENGTH_LONG).show()
        (activity as BikiniBottomActivity).supportActionBar?.title = args.planet!!.name

        //1. Href ou clé, quelque qui permet de faire la requête au Service
            // + Moins de mémoire
            // - Requête HTTP = latence
            // Adaptation de la classe modèle

        //2. Objet complète
            // - Plus de mémoire
            // Adaptation de la classe modèle


    }

    companion object {
        fun newInstance() =
            DetailPlanetFragment().apply {}
    }
}