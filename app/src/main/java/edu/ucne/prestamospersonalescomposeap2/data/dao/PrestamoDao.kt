package edu.ucne.prestamospersonalescomposeap2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.prestamospersonalescomposeap2.model.Prestamo
import kotlinx.coroutines.flow.Flow
@Dao
interface PrestamoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prestamo : Prestamo)

    @Delete
    suspend fun delete(prestamo: Prestamo)

    @Query("""
        SELECT * 
        FROM Prestamos
        WHERE prestamoId=:id
    """)
    fun find(id: Int): Flow<Prestamo>

    @Query("""
        SELECT * 
        FROM Prestamos
        ORDER BY prestamoId    
    """)
    fun getList(): Flow<List<Prestamo>>
}