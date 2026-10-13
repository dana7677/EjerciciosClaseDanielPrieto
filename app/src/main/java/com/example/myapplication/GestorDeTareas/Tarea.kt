package com.example.myapplication.GestorDeTareas

import com.example.myapplication.EjerciciosLambda.Producto2

data class Tarea(val titulo: String, val prioridad: Int, var completada: Boolean = false)


    //String.esTituloValido()
    //devuelve true si el texto no está en blanco y tiene al menos 3 caracteres.
    //List<Tarea>.pendientes(): devuelve solo las tareas no completadas.
fun Tarea.esTituloValido(): Boolean {

    if(titulo!=null && titulo.length>=3)
    {
        return true;
    }
    else
    {
        return false;
    }
}




