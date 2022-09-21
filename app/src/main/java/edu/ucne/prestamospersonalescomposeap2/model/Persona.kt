package edu.ucne.prestamospersonalescomposeap2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int = 0,
    val nombre: String,
    val telefono: String,
    val celular: String,
    val email: String,
    val ocupacionId: Int,
    val direccion: String,
    val fechaNacimiento: String,
)