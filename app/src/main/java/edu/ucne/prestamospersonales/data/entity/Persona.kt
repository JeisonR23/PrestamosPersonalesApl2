package edu.ucne.prestamospersonales.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity( tableName = "Personas")
data class Persona(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val telefono: String,
    val celular: String,
    val email: String,
    val direccion: String,
    val fechaNacimiento: String,
    val ocupacionId: Int

)