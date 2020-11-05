package ca.qc.cstj.spaceexplorer.models

import kotlinx.serialization.Serializable

@Serializable
data class Planet(val name:String, val temperature:Double, val icon:String)



