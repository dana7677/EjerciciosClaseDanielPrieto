package com.example.myapplication.GestorDeTareas

data class Tarea(
    val titulo: String,
    val prioridad: Int,
    var completada: Boolean = false
)
{
    val icono: String
        get() = if (completada) "[x]" else "[ ]"
}

// Comprueba si el título es válido
fun String.esTituloValido(): Boolean {
    return this.isNotBlank() && this.length >= 3
}

// Devuelve las tareas pendientes
fun List<Tarea>.pendientes(): List<Tarea> {
    return this.filter { tarea -> !tarea.completada }
}



