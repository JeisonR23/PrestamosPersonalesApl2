package edu.ucne.prestamospersonalescomposeap2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.prestamospersonalescomposeap2.data.PrestamosDb
import edu.ucne.prestamospersonalescomposeap2.data.dao.OcupacionDao
import edu.ucne.prestamospersonalescomposeap2.data.dao.PersonaDao
import edu.ucne.prestamospersonalescomposeap2.data.dao.PrestamoDao
import edu.ucne.prestamospersonalescomposeap2.data.repository.OcupacionRepository
import edu.ucne.prestamospersonalescomposeap2.data.repository.PersonaRepository
import edu.ucne.prestamospersonalescomposeap2.data.repository.PrestamoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosDb {
        val DATABASE_NAME = "PrestamosDb"
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonaDAO(prestamosDb: PrestamosDb): PersonaDao {
        return prestamosDb.personaDao
    }

    @Provides
    fun ProvideOcupacionDAO(prestamosDb: PrestamosDb): OcupacionDao {
        return prestamosDb.ocupacionDao
    }

    @Provides
    fun ProvidePrestamoDao(prestamosDb: PrestamosDb): PrestamoDao {
        return prestamosDb.prestamoDao
    }

    @Provides
    fun provideOcupacionRepository(ocupaciondao: OcupacionDao) : OcupacionRepository {
        return OcupacionRepository(ocupaciondao)
    }

    @Provides
    fun providePersonaRepository(personaDao: PersonaDao) : PersonaRepository {
        return PersonaRepository(personaDao)
    }

    @Provides
    fun providePrestamoRepository(prestamoDao: PrestamoDao) : PrestamoRepository {
        return PrestamoRepository(prestamoDao)
    }
}