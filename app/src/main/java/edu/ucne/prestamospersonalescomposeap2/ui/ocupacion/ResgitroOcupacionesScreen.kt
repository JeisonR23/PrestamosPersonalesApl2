package edu.ucne.prestamospersonalescomposeap2.ui.ocupacion

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroOcupacionesScreen(
    navHostController: NavHostController,
    viewModel: OcupacionViewModel = hiltViewModel()
){

    Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.Center) {

        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = {viewModel.nombre = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Ocupacion")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null)
            }
        )
        
        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            value = viewModel.salario.toString(),
            onValueChange = {viewModel.salario = it.toFloat()},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Salario")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null)
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            if (viewModel.salario < 0 || viewModel.nombre == ""){
                System.out.println("Debe ingresar un salario")
            }else {
                viewModel.Guardar()
                navHostController.navigateUp()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Guardar")
        }
    }
}