package edu.ucne.prestamospersonales.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "Ocupaciones")
data class Ocupacion(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val descripcion: String,
    val salario: String
)