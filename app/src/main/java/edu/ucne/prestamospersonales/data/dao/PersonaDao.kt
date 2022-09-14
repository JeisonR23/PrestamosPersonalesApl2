package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.data.entity.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(persona: Persona)

    @Delete
    suspend fun delete(persona: Persona)

    @Query("SELECT * FROM Personas")
    fun get(): Flow <List<Persona>>

    @Query("SELECT * FROM Personas WHERE id = :id")
    suspend fun getPersonasById(id:Int): Persona?

}