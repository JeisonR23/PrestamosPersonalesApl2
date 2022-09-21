package edu.ucne.prestamospersonalescomposeap2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonalescomposeap2.data.dao.OcupacionDao
import edu.ucne.prestamospersonalescomposeap2.data.dao.PersonaDao
import edu.ucne.prestamospersonalescomposeap2.data.dao.PrestamoDao
import edu.ucne.prestamospersonalescomposeap2.model.Ocupacion
import edu.ucne.prestamospersonalescomposeap2.model.Persona
import edu.ucne.prestamospersonalescomposeap2.model.Prestamo

@Database(
    entities = [
        Ocupacion::class,
        Persona::class,
        Prestamo::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
    abstract  val prestamoDao : PrestamoDao
}