package edu.ucne.prestamospersonalescomposeap2.ui.prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import edu.ucne.prestamospersonalescomposeap2.RowPrestamo
import edu.ucne.prestamospersonalescomposeap2.util.Screen

@Composable
fun ConsultaPrestamosScreen(
    navHostController: NavHostController,
    viewModel: PrestamosViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Prestamos") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate(Screen.RegistroPrestamosScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }

        }

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        ) {


            val lista = viewModel.prestamo.collectAsState(initial = emptyList())
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lista.value) { prestamo ->
                    RowPrestamo(prestamo = prestamo)
                }
            }
        }
    }
}