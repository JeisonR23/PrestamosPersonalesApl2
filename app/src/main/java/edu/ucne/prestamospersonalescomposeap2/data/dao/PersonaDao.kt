package edu.ucne.prestamospersonalescomposeap2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.prestamospersonalescomposeap2.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(persona : Persona)

    @Delete
    suspend fun delete(persona : Persona)

    @Query("""
        SELECT * 
        FROM Personas
        WHERE personaId=:personaId
    """)
    fun find(personaId: Int): Flow<Persona>

    @Query("""
        SELECT * 
        FROM Personas
        ORDER BY personaId    
    """)
    fun getList(): Flow<List<Persona>>

}