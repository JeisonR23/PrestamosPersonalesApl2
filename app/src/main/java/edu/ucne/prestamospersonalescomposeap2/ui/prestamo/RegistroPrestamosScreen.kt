package edu.ucne.prestamospersonalescomposeap2.ui.prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.peopleregistercompose.ui.personas.PersonaViewModel
import edu.ucne.prestamospersonalescomposeap2.OcupacionesSpinner
import edu.ucne.prestamospersonalescomposeap2.PersonasSpinner


@Composable
fun RegistroPrestamosScreen(
    navHostController: NavHostController,
    viewModel: PrestamosViewModel = hiltViewModel()
) {
    var concepto by rememberSaveable() {
        mutableStateOf("")
    }
    var ocupacionId by rememberSaveable() {
        mutableStateOf(0)
    }
    var monto by rememberSaveable() {
        mutableStateOf(0f)
    }
    var balance by rememberSaveable() {
        mutableStateOf(0f)
    }

    Column(modifier = Modifier.padding(8.dp)) {

        OutlinedTextField(
            value = viewModel.concepto,
            onValueChange = { viewModel.concepto = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Concepto")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        PersonasSpinner()

        OutlinedTextField(
            value = viewModel.monto.toString(),
            onValueChange = { viewModel.monto = it.toFloat() },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Monto")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            value = viewModel.balance.toString(),
            onValueChange = { viewModel.balance = it.toFloat() },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Balance")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        Button(onClick = {
            if (viewModel.concepto == "" || viewModel.monto <0 || viewModel.balance <0
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