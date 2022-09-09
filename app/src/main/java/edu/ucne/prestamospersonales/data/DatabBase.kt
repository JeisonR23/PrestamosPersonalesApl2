package edu.ucne.prestamospersonales.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.data.dao.OcupacionDao
import edu.ucne.prestamospersonales.data.entity.Ocupacion

@Database(
    entities = [Ocupacion::class],
    version = 2,
    exportSchema = false
)
abstract class DatabBase:RoomDatabase() {

    abstract val  ocupacionDao: OcupacionDao

    companion object {

        @Volatile
        private var INSTANCE: DatabBase? = null

        fun getInstance(context: Context): DatabBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabBase::class.java,
                        "Prestamos.bd"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}