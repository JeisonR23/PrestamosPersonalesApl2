package edu.ucne.prestamospersonalescomposeap2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "Prestamos")
data class Prestamo (
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,
    val concepto: String,
    val personaId: Int,
    val monto: Float,
    val balance: Float

    )
