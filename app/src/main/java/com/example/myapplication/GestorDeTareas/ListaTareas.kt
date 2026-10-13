package com.example.myapplication.GestorDeTareas

class ListaTareas(val misTareas: List<Tarea>) {

    fun pendientes(): List<Tarea> {
        return misTareas.filter {
            tarea -> !tarea.completada  //Solo devolvemos las que no estan completadas
        }
    }
}