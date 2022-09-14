package edu.ucne.prestamospersonales.ui.persona

import android.content.Context
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import edu.ucne.prestamospersonales.data.DatabBase
import edu.ucne.prestamospersonales.data.entity.Ocupacion
import edu.ucne.prestamospersonales.data.entity.Persona
import kotlinx.coroutines.launch

public val showDialog = mutableStateOf(false)
private val ColumnScope.applicationContext: Context?
    get() {
        return null
    }

@Composable
fun personaScreen(
    IsErrorNombre: Boolean,
    IsErrorTelefono: Boolean,
    IsErrorCelular: Boolean,
    IsErrorDireccion: Boolean,
    IsErrorEmail: Boolean,
    IsErrorFechaNa: Boolean,
    IsMsNombre: String,
    IsMsTelefono: String,
    IsMsCelular: String,
    IsMsDireccion: String,
    IsMsEmail: String,
    IsMsrFechaNa: String


): Unit {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val prestamosDb = DatabBase.getInstance(this.applicationContext)
        val scope = rememberCoroutineScope()
        var Nombre by remember { mutableStateOf("") }
        var Telefono by remember { mutableStateOf("") }
        var Celular by remember { mutableStateOf("") }
        var Email by remember { mutableStateOf("") }
        var Direccion by remember { mutableStateOf("") }
        var FechaNacimiento by remember { mutableStateOf("") }
        var OcupacionId by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val items = listOf("Doctor", "Ingeniero", "Chef", "Dentista", "Ebanista")
        val disabledValue = "B"
        var selectedIndex by remember { mutableStateOf(0) }


        Text(
            //Text Label
            text = "Registro de Personas",
            fontSize = 25.sp,
        )

        Spacer(modifier = Modifier.height(25.dp))
        Box() {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nombre") },
                value = Nombre,
                onValueChange = { value -> Nombre = value }
            )
            if (IsErrorNombre == true) {

                Text(text = IsMsNombre)
            }

        }


        Spacer(modifier = Modifier.height(10.dp)) //Spacer between Textfield
        Box() {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Telefono") },
                value = Telefono,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onValueChange = { value -> Telefono = value }
            )
            if (IsErrorTelefono == true) {

                Text(text = IsMsTelefono)
            }
        }

        Spacer(modifier = Modifier.height(10.dp)) //Spacer between Textfield
        Box() {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), //TextField Salario
                label = { Text(text = "Celular") },
                value = Celular,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onValueChange = { value -> Celular = value }
            )
            if (IsErrorTelefono == true) {

                Text(text = IsMsCelular)
            }
        }


        Spacer(modifier = Modifier.height(10.dp)) //Spacer between Textfield
        Box() {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), //TextField Salario
                label = { Text(text = "Email") },
                value = Email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = { value -> Email = value }
            )
            if (IsErrorTelefono == true) {

                Text(text = IsMsEmail)
            }
        }

        Spacer(modifier = Modifier.height(10.dp)) //Spacer between Textfield
        Box() {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), //TextField Salario
                label = { Text(text = "Direccion") },
                value = Direccion,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = { value -> Direccion = value }
            )
            if (IsErrorTelefono == true) {

                Text(text = IsMsDireccion)
            }
        }
        Spacer(modifier = Modifier.height(10.dp)) //Spacer between Textfield

        Box() {


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), //TextField Salario
                label = { Text(text = "Fecha Nacimiento") },
                value = FechaNacimiento,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = { value -> FechaNacimiento = value }
            )
            if (IsErrorTelefono == true) {

                Text(text = IsMsrFechaNa)
            }
        }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    scope.launch {
                        prestamosDb?.personaDao?.insert(
                            Persona(
                                nombre = Nombre,
                                telefono = Telefono,
                                celular = Celular,
                                email = Email,
                                direccion = Direccion,
                                fechaNacimiento = FechaNacimiento,
                                ocupacionId = 1
                            )
                        )
                        showDialog.value = false

                    }
                }
            ) {
                Text(text = "Agregar")

            }
        }
    }


    fun isNumeric(aux: String): Boolean {
        return try {
            aux.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }


/*fun validacion(
    Nombre: String, Telefono: String, Celular: String,
    Email: String, Direccion: String
): Boolean {

    var isErrorNombres = true
    var isErrorTelefono = true
    var isErrorCelular = true
    var isErrorEmail = true
    var isErrorDireccion = true

    var errorNombres = ""
    var errorTelefono = ""
    var errorCelular = ""
    var errorEmail = ""
    var errorDireccion = ""


    if (Nombre.isEmpty()) {
        isErrorNombres = false
        errorNombres = "*Campo Obligatorio*"
    } else if (Nombre.isDigitsOnly()) {
        isErrorNombres = false
        errorNombres = "Solo se permiten Caracteres"
    } else if (!(Nombre.any { it.isLetter() })) {
        isErrorNombres = false
        errorNombres = "No se permiten simbolos"
    }

    if (Telefono.isEmpty()) {
        isErrorTelefono = false
        errorTelefono = "*Campo Obligatorio*"
    } else if (Telefono.length < 10 && Telefono.isNotEmpty()) {
        isErrorTelefono = false
        errorTelefono = "Minimo 10 Numeros"
    } else if (!isNumeric(Telefono)) {
        isErrorTelefono = false
        errorTelefono = "No es una Numero"
    }

    if (Celular.isEmpty()) {
        isErrorCelular = false
        errorCelular = "*Campo Obligatorio*"
    } else if (Celular.length < 10 && Celular.isNotEmpty()) {
        isErrorCelular = false
        errorCelular = "Minimo (10) Numeros"
    } else if (!isNumeric(Celular)) {
        isErrorCelular = false
        errorCelular = "No es una Numero"
    }

    if (Email.isBlank()) {
        isErrorEmail = false
        errorEmail = "*Campo Obligatorio*"
    } else if (
        !Patterns.EMAIL_ADDRESS
            .matcher(Email)
            .matches()
    ) {
        isErrorEmail = false
        errorEmail = "El Email no es valido"
    }

    if (Direccion.length < 5 && Direccion.isNotEmpty()) {
        isErrorDireccion = false
        errorDireccion = "Caracteres insuficientes Mínimo, (5)";
    } else if (Direccion.isEmpty()) {
        isErrorDireccion = false
        errorDireccion = "*Campo Obligatorio*";
    } else if (!(Direccion.any { it.isLetter() })) {
        isErrorDireccion = false
        errorDireccion = "Direccion no valida";
    }

    personaScreen(
        IsErrorNombre = isErrorNombres,
        IsErrorTelefono = isErrorTelefono,
        IsErrorCelular = isErrorCelular,
        IsErrorDireccion = isErrorDireccion,
        IsErrorEmail = isErrorEmail,
        IsErrorFechaNa = false,
        IsMsNombre = errorNombres,
        IsMsTelefono = errorTelefono,
        IsMsCelular = errorCelular,
        IsMsDireccion = errorDireccion,
        IsMsEmail = errorEmail,
        IsMsrFechaNa = ""
    )
    var aux =
        (isErrorNombres && isErrorTelefono && isErrorCelular && isErrorEmail && isErrorDireccion)
    return aux
}}*/

