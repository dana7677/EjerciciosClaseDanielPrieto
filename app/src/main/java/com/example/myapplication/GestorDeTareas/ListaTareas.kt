package com.example.myapplication.GestorDeTareas

class ListaTareas(
    var misTareas: MutableList<Tarea> = mutableListOf(),
    val alCompletar: (Tarea) -> Unit
) {


    val sugerencias: List<String> by lazy {
        println("Cargando sugerencias...")
        listOf("Repasar Kotlin", "Instalar el emulador")
    }

    // lista += tarea: añade la tarea solo si su título es válido; si no, muestra Título no válido: '...'.
    operator fun plusAssign(p: Tarea) {
        if (p.titulo.esTituloValido()) {
            misTareas.add(p)
        } else {
            println("Título no válido: '${p.titulo}'")
        }
    }

    // lista["título"]: devuelve la tarea con ese título, o null si no existe.
    operator fun get(nombre: String): Tarea? {
        return misTareas.find { it.titulo == nombre }
    }

    // "título" in lista: indica si existe una tarea con ese título.
    operator fun contains(nombre: String): Boolean {
        return misTareas.any { tarea -> tarea.titulo == nombre }
    }

    // completar(titulo): busca la tarea; si existe (usa ?.let), la marca como completada
    // y llama a alCompletar; si no existe, muestra No existe la tarea: ....
    fun completar(nombre: String) {
        misTareas.find { it.titulo == nombre }?.let { tarea ->
            tarea.completada = true
            alCompletar(tarea)
        } ?: println("No existe la tarea: $nombre")
    }

    // todas(): devuelve la lista de tareas.
    fun todas(): MutableList<Tarea> {
        return misTareas
    }
}