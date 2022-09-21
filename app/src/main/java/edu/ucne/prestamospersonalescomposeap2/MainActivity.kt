package edu.ucne.prestamospersonalescomposeap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.peopleregistercompose.ui.ocupacion.ConsultaOcupacionesScreen
import com.example.peopleregistercompose.ui.personas.ConsultaPersonaScreen
import com.example.peopleregistercompose.ui.personas.PersonaViewModel
import com.example.peopleregistercompose.ui.personas.RegistroPersonaScreen
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.prestamospersonalescomposeap2.model.Ocupacion
import edu.ucne.prestamospersonalescomposeap2.model.Persona
import edu.ucne.prestamospersonalescomposeap2.model.Prestamo
import edu.ucne.prestamospersonalescomposeap2.ui.ocupacion.OcupacionViewModel
import edu.ucne.prestamospersonalescomposeap2.ui.ocupacion.RegistroOcupacionesScreen
import edu.ucne.prestamospersonalescomposeap2.ui.prestamo.ConsultaPrestamosScreen
import edu.ucne.prestamospersonalescomposeap2.ui.prestamo.PrestamosViewModel
import edu.ucne.prestamospersonalescomposeap2.ui.prestamo.RegistroPrestamosScreen
import edu.ucne.prestamospersonalescomposeap2.ui.theme.PrestamosPersonalesComposeAp2Theme
import edu.ucne.prestamospersonalescomposeap2.util.Screen

var selectedOcupacion: String? = null

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosPersonalesComposeAp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screen.ConsultaPersonaScreen.route

    ) {
        composable(Screen.ConsultaOcupacionScreen.route) {
            ConsultaOcupacionesScreen(navHostController = navHostController)
        }
        composable(Screen.RegistroOcupacionesScreen.route) {
            RegistroOcupacionesScreen(navHostController = navHostController)
        }
        composable(Screen.ConsultaPersonaScreen.route) {
            ConsultaPersonaScreen(navHostController = navHostController)
        }
        composable(Screen.RegistroPersonaScreen.route) {
            RegistroPersonaScreen(navHostController = navHostController)
        }

        composable(Screen.ConsultaPrestamosScreen.route) {
            ConsultaPrestamosScreen(navHostController = navHostController)
        }
        composable(Screen.RegistroPrestamosScreen.route) {
            RegistroPrestamosScreen(navHostController = navHostController)
        }


    }
}

@Composable
fun OcupacionesSpinner(
    viewModel: OcupacionViewModel = hiltViewModel(),
    viewModelP: PersonaViewModel = hiltViewModel()
) {
    val ocupaciones = viewModel.ocupaciones.collectAsState(initial = emptyList())

    var ocupacionText by remember {
        mutableStateOf("")
    }
    var expended by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .clickable {
                expended = !expended
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = ocupacionText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(expanded = expended, onDismissRequest = { expended = false }) {
                ocupaciones.value.forEach { ocupacion ->
                    DropdownMenuItem(onClick = {
                        viewModelP.ocupacionId = ocupacion.ocupacionId
                        expended = false
                        ocupacionText = ocupacion.descripcion
                        selectedOcupacion = ocupacion.descripcion
                    }) {
                        Text(text = ocupacion.descripcion)
                    }
                }

            }
        }
    }
}

@Composable
fun PersonasSpinner(
    viewModel: PersonaViewModel = hiltViewModel(),
    viewModelP: PrestamosViewModel = hiltViewModel()
) {
    val persona = viewModel.personas.collectAsState(initial = emptyList())

    var personaText by remember {
        mutableStateOf("")
    }
    var expended by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .clickable {
                expended = !expended
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = personaText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(expanded = expended, onDismissRequest = { expended = false }) {
                persona.value.forEach { persona ->
                    DropdownMenuItem(onClick = {
                        viewModelP.personaId = persona.personaId
                        expended = false
                        personaText = persona.nombre
                        selectedOcupacion = persona.nombre
                    }) {
                        Text(text = persona.nombre)
                    }
                }

            }
        }
    }
}
@Composable
fun RowPersona(persona: Persona) {
    Column() {
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Personas")
        Text(text = " Nombre : " + persona.nombre)
        Text(text = "Telefono : " + persona.telefono)
        Text(text = "Celular : " + persona.celular)
        Text(text = "Email : "    + persona.email)
        Text(text ="Ocupacion : " + persona.ocupacionId.toString())
        Text(text ="Direccion : " +  persona.direccion)
        Text(text = "Fecha Nacimiento : " + persona.fechaNacimiento)
        Spacer(modifier = Modifier.padding(3.dp))
    }
}

@Composable
fun RowPrestamo(prestamo: Prestamo) {
    Column() {
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Prestamo")
        Text(text = "Concepto : " + prestamo.concepto)
        Text(text = "Cliente : " + prestamo.personaId.toString())
        Text(text = "Monto : " + prestamo.monto)
        Text(text = "Balance : "    + prestamo.balance)
        Spacer(modifier = Modifier.padding(3.dp))
    }
}

@Composable
fun RowOcupacion(ocupacion: Ocupacion) {
    Column() {
        Text(text = "Ocupacion: " + ocupacion.descripcion)
        Text(text = "Salario:" + ocupacion.salario.toString())
        Spacer(modifier = Modifier.padding(2.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PrestamosPersonalesComposeAp2Theme() {
        MyApp()
    }
}