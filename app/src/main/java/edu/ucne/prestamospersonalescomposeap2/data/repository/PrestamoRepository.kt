package edu.ucne.prestamospersonalescomposeap2.data.repository

import edu.ucne.prestamospersonalescomposeap2.data.dao.PrestamoDao
import edu.ucne.prestamospersonalescomposeap2.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
) {
    suspend fun insert(prestamo : Prestamo){
        prestamoDao.insert(prestamo)
    }
    suspend fun delete(prestamo : Prestamo){
        prestamoDao.delete(prestamo)
    }

    fun find(pretamoId: Int): Flow<Prestamo> {
        return prestamoDao.find(pretamoId)
    }

    fun getList(): Flow<List<Prestamo>> {
        return prestamoDao.getList()
    }
}