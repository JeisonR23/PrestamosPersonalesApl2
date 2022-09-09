package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.data.entity.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ocupacion: Ocupacion)

    @Delete
    suspend fun delete(ocupacion: Ocupacion)

    @Query("SELECT * FROM Ocupaciones")
    fun get(): Flow<List<Ocupacion>>

    @Query("SELECT * FROM Ocupaciones WHERE id = :id")
    suspend fun getOcupacionesById(id:Int): Ocupacion?

}