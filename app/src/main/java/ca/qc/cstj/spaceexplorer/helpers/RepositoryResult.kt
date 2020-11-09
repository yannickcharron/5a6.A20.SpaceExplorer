package ca.qc.cstj.spaceexplorer.helpers

import java.lang.Exception


// Liste ou Collection -> Success
// Objet --> Success
// Erreur, Null -> Error

sealed class RepositoryResult<out R> {
    data class Success<out T>(val data:T) : RepositoryResult<T>()
    data class Error(val exception: Exception):RepositoryResult<Nothing>()
}

