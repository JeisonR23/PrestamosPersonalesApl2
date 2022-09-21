package edu.ucne.prestamospersonalescomposeap2.data.repository

import edu.ucne.prestamospersonalescomposeap2.data.dao.PersonaDao
import edu.ucne.prestamospersonalescomposeap2.model.Persona
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val personaDao: PersonaDao
) {

    suspend fun insert(persona : Persona){
        personaDao.insert(persona)
    }
    suspend fun delete(persona : Persona){
        personaDao.delete(persona)
    }
    fun find(personaId: Int): Flow<Persona> {
        return personaDao.find(personaId)
    }
    fun getList(): Flow<List<Persona>> {
        return personaDao.getList()
    }
}