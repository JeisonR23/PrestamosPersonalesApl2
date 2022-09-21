package edu.ucne.prestamospersonalescomposeap2.ui.prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonalescomposeap2.PersonasSpinner
import edu.ucne.prestamospersonalescomposeap2.data.repository.PersonaRepository
import edu.ucne.prestamospersonalescomposeap2.data.repository.PrestamoRepository
import edu.ucne.prestamospersonalescomposeap2.model.Prestamo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamosViewModel @Inject constructor(
    val prestamoRepository: PrestamoRepository
) : ViewModel() {
    var concepto by mutableStateOf("")

    var personaId by mutableStateOf(0)

    var monto by mutableStateOf(0f)

    var balance by mutableStateOf(0f)

    var prestamo = prestamoRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch{
            prestamoRepository.insert(
                Prestamo(
                    concepto =concepto,
                    personaId = personaId ,
                    monto = monto,
                    balance = balance
                )
            )
        }
    }
}