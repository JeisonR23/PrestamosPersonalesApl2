package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import edu.ucne.prestamospersonales.data.DatabBase
import edu.ucne.prestamospersonales.data.entity.Ocupacion
import edu.ucne.prestamospersonales.ui.ocupacion.ocupacionScreen
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         DatabBase.getInstance(this.applicationContext)
        setContent {
            PrestamosPersonalesTheme {
                // A surface container using the 'background' color from the theme
               ocupacionScreen()
                }
            }
        }
    }





