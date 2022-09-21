package edu.ucne.prestamospersonalescomposeap2.ui.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonalescomposeap2.data.repository.OcupacionRepository
import edu.ucne.prestamospersonalescomposeap2.model.Ocupacion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val ocupacionRepository : OcupacionRepository
) : ViewModel(){
    var nombre by mutableStateOf("")
    var salario by mutableStateOf(0f)
    var ocupaciones = ocupacionRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            ocupacionRepository.insert(
                Ocupacion(
                    descripcion = nombre,
                    salario =salario
                )
            )
        }
    }
}