package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import edu.ucne.prestamospersonales.data.DatabBase
import edu.ucne.prestamospersonales.data.entity.Ocupacion
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prestamosDb = DatabBase.getInstance(this.applicationContext)
        setContent {
            PrestamosPersonalesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scope = rememberCoroutineScope()

                    Button(onClick = {
                        scope.launch {
                             prestamosDb.ocupacionDao.insert(
                                Ocupacion(
                                    descripcion = "Ingeniero",
                                    salario = 10000.0
                                )
                            )
                        }
                    }) {
                        Text(text = "Agregar Ocupacion")

                    }
                }
            }
        }
    }
}

