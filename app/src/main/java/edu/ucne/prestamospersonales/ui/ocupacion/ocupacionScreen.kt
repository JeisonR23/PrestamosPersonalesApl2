package edu.ucne.prestamospersonales.ui.ocupacion

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucne.prestamospersonales.data.DatabBase
import edu.ucne.prestamospersonales.data.entity.Ocupacion
import kotlinx.coroutines.launch


private val ColumnScope.applicationContext: Context?
    get() {
        return null
    }

@Composable
fun ocupacionScreen(

){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val prestamosDb = DatabBase.getInstance(this.applicationContext)
        val scope = rememberCoroutineScope()
        var Descripcion by remember { mutableStateOf("") }
        var Salario by remember { mutableStateOf("") }

        Text(
            //Text Label
            text = "Registro de Ocupaciones",
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(25.dp)) //Spacer between Text and Descripción
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Descricion
            label = { Text(text = "Descripcion") },
            value = Descripcion,
            onValueChange = { value -> Descripcion = value}
        )
        Spacer(modifier = Modifier.height(10.dp)) //Spacer between Textfield
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Salario
            label = { Text(text = "Salario") },
            value = Salario,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { value -> Salario = value}
        )
        Button(
            onClick = {
                scope.launch {
                    prestamosDb?.ocupacionDao?.insert(
                        Ocupacion(
                            descripcion = Descripcion,
                            salario = Salario
                        )

                    )
                }
            }
        ) {
            Text(text = "Agregar")

        }
    }
}

