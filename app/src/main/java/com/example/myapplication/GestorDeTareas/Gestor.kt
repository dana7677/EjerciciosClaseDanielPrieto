package com.example.myapplication.GestorDeTareas

fun main() {

    val lista = ListaTareas { t -> println("¡Bien! Has completado: ${t.titulo}") }.apply {
        this += Tarea("Hacer la práctica", 1)
        this += Tarea("Leer los apuntes", 2)
        this += Tarea("Comprar pan", 3)
        this += Tarea("ok", 3)
    }

    println("=== Tareas ===")
    lista.todas().forEach { println("${it.icono} ${it.titulo} (prioridad ${it.prioridad})") }

    println("=== Completar ===")
    lista.completar("Leer los apuntes")
    lista.completar("Viajar a Marte")

    println("=== Pendientes ordenadas por prioridad ===")
    lista.todas().pendientes().sortedBy { it.prioridad }.forEach { println("${it.icono} ${it.titulo}") }

    println("=== Consultas ===")
    println("Comprar pan" in lista)
    println(lista["Comprar pan"]?.prioridad)
    println(lista["Dormir"]?.prioridad)

    println("=== Sugerencias ===")
    println(lista.sugerencias)
    println(lista.sugerencias.size)
}