package edu.ucne.prestamospersonalescomposeap2.util

sealed class Screen (val route : String){

    object RegistroPersonaScreen : Screen("RegistroPersonas")

    object RegistroOcupacionesScreen : Screen("RegistroOcupaciones")

    object RegistroPrestamosScreen : Screen("RegistroPrestamos")

    object ConsultaPersonaScreen : Screen("ConsultaPersonas")

    object ConsultaOcupacionScreen : Screen("ConsultaOcupacion")

    object ConsultaPrestamosScreen : Screen("ConsultaPrestamos")
}