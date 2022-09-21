package com.example.peopleregistercompose.ui.personas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import edu.ucne.prestamospersonalescomposeap2.OcupacionesSpinner

@Composable
fun RegistroPersonaScreen(
    navHostController: NavHostController,
    viewModel: PersonaViewModel = hiltViewModel()
) {
    var person by rememberSaveable() {
        mutableStateOf("")
    }
    var telefono by rememberSaveable() {
        mutableStateOf("")
    }
    var celular by rememberSaveable() {
        mutableStateOf("")
    }

    var email by rememberSaveable() {
        mutableStateOf("")
    }
    var ocupacionId by rememberSaveable() {
        mutableStateOf("")
    }

    var direccion by rememberSaveable() {
        mutableStateOf("")
    }
    var FechaN by rememberSaveable() {
        mutableStateOf("")
    }


    Column(modifier = Modifier.padding(8.dp)) {

        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.nombre = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la Persona")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            value = viewModel.telefono,
            onValueChange = { viewModel.telefono = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Telefono")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            value = viewModel.celular,
            onValueChange = { viewModel.celular = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Celular")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            }
        )

        OcupacionesSpinner()

        OutlinedTextField(
            value = viewModel.direccion,
            onValueChange = { viewModel.direccion = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Direccion")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            value = viewModel.FechaN,
            onValueChange = { viewModel.FechaN = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Fecha Nacimiento")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            }
        )

        OutlinedButton(onClick = {
            if (viewModel.nombre == "" || viewModel.telefono == "" || viewModel.celular == ""
                || viewModel.email == "" || viewModel.direccion == "" || viewModel.FechaN == ""
            ) {
                System.out.println("Favor Llenar los Campos")
            } else {
                navHostController.navigateUp()
                viewModel.Guardar()
            }
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Guardar")
        }
    }
}