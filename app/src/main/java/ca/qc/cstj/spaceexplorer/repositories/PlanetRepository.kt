package ca.qc.cstj.spaceexplorer.repositories

import ca.qc.cstj.spaceexplorer.helpers.RepositoryResult
import ca.qc.cstj.spaceexplorer.helpers.Services
import ca.qc.cstj.spaceexplorer.models.Planet
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json



object PlanetRepository {

    suspend fun getPlanets(): RepositoryResult<List<Planet>> {

        //AJAX Get
        return withContext(Dispatchers.IO) {
            //Dans un autre thread
            val (_, _, result) = Services.PLANET_SERVICE.httpGet().responseJson()

            when (result) {
                is Result.Success -> {
                    //TODO: Transformer la string en List<Planet> --> Déserialiser (DéSpécialK)
                    RepositoryResult.Success(Json { ignoreUnknownKeys = true }.decodeFromString(result.value.content))
                }
                is Result.Failure -> {
                    RepositoryResult.Error(result.getException())
                }

            }
        }


//        Services.PLANET_SERVICE.httpGet().responseJson { request, response, result ->
//
//            when(result) {
//                is Result.Success -> {
//                    val planets = result.value.content
//                }
//                is Result.Failure -> {
//
//                }
//            }
//
//        }


    }
}
