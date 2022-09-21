package edu.ucne.prestamospersonalescomposeap2.data.repository

import edu.ucne.prestamospersonalescomposeap2.data.dao.OcupacionDao
import edu.ucne.prestamospersonalescomposeap2.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    val ocupacionDao: OcupacionDao
) {

    suspend fun insert(ocupacion: Ocupacion) {
        ocupacionDao.insert(ocupacion)
    }

    suspend fun delete(ocupacion: Ocupacion) {
        ocupacionDao.delete(ocupacion)
    }

    fun find(ocupacionId: Int): Flow<Ocupacion> {
        return ocupacionDao.find(ocupacionId)
    }

    fun getList(): Flow<List<Ocupacion>> {
        return ocupacionDao.getList()
    }
}
