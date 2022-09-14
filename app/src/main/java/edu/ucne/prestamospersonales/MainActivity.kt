package edu.ucne.prestamospersonales

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucne.prestamospersonales.data.DatabBase
import edu.ucne.prestamospersonales.data.entity.Ocupacion
import edu.ucne.prestamospersonales.data.entity.Persona
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import kotlinx.coroutines.launch
import edu.ucne.prestamospersonales.ui.ocupacion.ocupacionScreen
import edu.ucne.prestamospersonales.ui.persona.personaScreen
import edu.ucne.prestamospersonales.ui.principal

public val showDialog = mutableStateOf(false)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DatabBase.getInstance(this.applicationContext)
        setContent {
            PrestamosPersonalesTheme {
                personaScreen(
                    IsErrorNombre = true,
                    IsErrorTelefono =true ,
                    IsErrorCelular = true,
                    IsErrorDireccion = true,
                    IsErrorEmail = true,
                    IsErrorFechaNa = true,
                    IsMsNombre = "",
                    IsMsTelefono = "",
                    IsMsCelular = "",
                    IsMsDireccion ="" ,
                    IsMsEmail = "",
                    IsMsrFechaNa =""
                )
                        // A surface container using the 'background' color from the theme
                val scope = rememberCoroutineScope()
                if (showDialog.value) {
                    ocupacionScreen()
                  }

            }
                }
            }
        }




