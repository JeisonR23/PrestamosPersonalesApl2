package edu.ucne.prestamospersonalescomposeap2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.prestamospersonalescomposeap2.model.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ocupacion: Ocupacion)

    @Delete
    suspend fun delete(ocupacion: Ocupacion)
    @Query(
        """
        SELECT * 
        FROM Ocupaciones
        WHERE ocupacionId=:ocupacionId
    """
    )
    fun find(ocupacionId: Int): Flow<Ocupacion>

    @Query(
        """
        SELECT * 
        FROM Ocupaciones
        ORDER BY ocupacionId    
    """
    )
    fun getList(): Flow<List<Ocupacion>>
}