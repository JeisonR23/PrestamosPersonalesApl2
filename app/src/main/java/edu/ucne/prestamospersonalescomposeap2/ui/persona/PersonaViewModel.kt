package com.example.peopleregistercompose.ui.personas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonalescomposeap2.data.repository.PersonaRepository
import edu.ucne.prestamospersonalescomposeap2.model.Persona
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonaViewModel @Inject constructor(
    val personaRepository: PersonaRepository
) : ViewModel() {
    var nombre by mutableStateOf("")

    var telefono by mutableStateOf("")

    var celular by mutableStateOf("")

    var email by mutableStateOf("")

    var ocupacionId by mutableStateOf(0)

    var direccion by mutableStateOf("")

    var FechaN by mutableStateOf("")

    var personas = personaRepository.getList()
    private set

    fun Guardar(){
        viewModelScope.launch{
            personaRepository.insert(
                Persona(
                    nombre = nombre,
                    telefono = telefono,
                    celular = celular,
                    email = email,
                    ocupacionId = ocupacionId,
                    direccion = direccion,
                    fechaNacimiento = FechaN
                )
            )
        }
    }
}