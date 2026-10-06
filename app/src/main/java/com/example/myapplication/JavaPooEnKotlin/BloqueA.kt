package com.example.myapplication.JavaPooEnKotlin
fun main() {
//Variables y plantillas

    var modulo = "PMDM";
    var horas = 4;
    horas = horas + 1;
    var media = 7.25;
    println("El modulo " + modulo + " tiene " + horas + " horas y una media de " + media);

    println("El doble de horas es " + (horas * 2));


//A2 Conversión de tipos

    var a = 7
    var b = 2
    var division = a.toDouble() / b.toDouble()
    var grande = a;
    var numero = "123";
    println(division.toString() + " " + grande.toString() + " " + numero);


//A3 Nulos

    fun obtenerApodo(): String? = "Rayo"
    var apodo = obtenerApodo()


    var longitud = 0
    when {
        apodo != null -> {
            longitud = apodo.toString().length;
        }

        else -> {
            longitud = 0;
        }
    }

    var saludo = "Hola, ${apodo?.uppercase() ?: "ANÓNIMO"}"
    println(longitud.toString() + " " + saludo);


//A4. Bucles


    for (i in 0..10) {
        if (i % 2 == 0) {
            println(i.toString() + "")
        }
    }
    for (i in 20 downTo -5) {
        println(i.toString() + " ")
    }


//A5 Switch-> When

    var tipo: String;


    fun tipoRespuesta(parametro: String): Int {
        // Cuerpo de la función
        return parametro.toInt()
    }

    var codigoHttp = tipoRespuesta("200")

    when (codigoHttp) {
        200,201 -> tipo = "Exito";
        301,302 -> tipo = "Redirección";
        404 -> tipo = "No encontrado";

        else -> if (codigoHttp>= 500 && codigoHttp < 600) {
            tipo = "Error del servidor"
        } else {
            tipo = "Otro";
        }
    }


//A6 Funciones y colecciones

    val listaNotasMates = listOf(5.0, 7.0, 9.0)
    val listaVacia = emptyList<Int>()

    fun media(notas: List<Double>): Double {

        if (notas.isEmpty()) {
            return 0.0
        }
        var suma = 0.0;
        for (i in notas) {
            suma += i;
        }
        return suma / notas.size.toDouble();
    }

    fun formatear(nombre: String, nota: Double, unidad: String): String {
        return (nombre + ": " + nota + " " + unidad);
    }
    fun formatear(nombre: String, nota: Double): String {
        return formatear(nombre, nota, "Puntos");
    }

    println(formatear("Daniel Prieto", media(listaNotasMates)))


    //A7 Mapa del inventario
    val mapaInventario = mutableListOf<Pair<Int, String>>()

    mapaInventario.add(10 to "Gominolas")
    mapaInventario.add(5 to "Refrescos")
    mapaInventario.add(2 to "Bocatas")

    fun retirarStock(): Boolean
    {

        return true;
    }
}
