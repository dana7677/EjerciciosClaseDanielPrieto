package com.example.myapplication.EjerciciosLambda

// A1

fun main() {
    val mitad: (Double) -> Double =
        { a -> a / 2.0f } // TODO: lambda que recibe un Double y devuelve su mitad
    val esCaro: (Double) -> Boolean =
        { a -> a > 3 } // TODO: lambda que recibe un Double y devuelve true si es mayor que 3

    println(mitad(3.0))
    println(esCaro(4.5))
    println(esCaro(1.2))


//A2

    data class Producto(val nombre: String, val precio: Double)


    val productos = listOf(
        Producto("pan", 1.5),
        Producto("leche", 0.9),
        Producto("queso", 4.5),
        Producto("café", 3.25)
    )

    //val pares = numeros.filter { it % 2 == 0 }
    val baratos = productos.filter { it.precio < 2 }
    val nombres = productos.map { it.nombre }

    println(baratos)
    println(nombres)


//A3

    class Boton {
        private var alPulsar: () -> Unit = {}

        fun setOnClickListener(accion: () -> Unit) {
            alPulsar = accion
        }

        fun pulsar() = alPulsar()
    }


    val carrito = mutableListOf<String>()
    val botonAnadir = Boton()

    botonAnadir.setOnClickListener { carrito.add("pan"); println("Carrito:$carrito") }

    println("Carrito: $carrito")
    botonAnadir.pulsar()
    botonAnadir.pulsar()


//A4

    fun aplicarOferta(precio: Double, oferta: (Double) -> Double): Double {
        return oferta(precio)
    }


    println(aplicarOferta(4.0) { a -> a / 2 })
    println(aplicarOferta(4.0) { a -> a - 1 })
    println(aplicarOferta(4.0) { 0.0 })

    main2()
    main3()
    main4()
    main5()
    main6()
}
//A5

    data class Producto2(val nombre: String, val precio: Double)
     fun String.capitalizar(): String {return replaceFirstChar { it.uppercase()}}
         val Producto2.esBarato: Boolean
          get() = precio < 3.0

fun main2()
    {
        val pan = Producto2("pan", 1.5)
        val queso = Producto2("queso", 4.5)

        println("leche".capitalizar())
        println(pan.esBarato)
        println(queso.esBarato)
    }

//A6

data class Producto3(val nombre: String, val precio: Double)

val productos = listOf(Producto3("pan", 1.5), Producto3("leche", 0.9))

fun buscar(nombre: String): Producto3? = productos.find { it.nombre == nombre }

fun main3() {
    buscar("pan")?.let {println(it.nombre + " cuesta " + it.precio) }
    buscar("caviar")?.let {println("Hay caviar") } ?: run {
        println("No hay caviar")
    }
}

//A7

class Pedido {
    var cliente = ""
    var direccion = ""
    var urgente = false
}

fun main4() {
    val pedido = Pedido().apply {
        cliente = "Ana"
        direccion = "Calle Mayor 1"
        urgente = true
    }

    println("${pedido.cliente} - ${pedido.direccion} - urgente: ${pedido.urgente}")
}
//A8

data class Producto(val nombre: String, val precio: Double)

class Carrito {
    private val productos = mutableListOf<Producto>()

     operator fun plusAssign(p: Producto){ productos.add(p)}
    operator fun get(nombre: String): Producto?
    {
        return productos.find { it.nombre==nombre }
    }


     operator fun contains(nombre: String): Boolean
     {
         if(productos.any { it.nombre == nombre })
         {
             return true
         }
         else
         {
             return false
         }

     }

    fun total(): Double = productos.sumOf { it.precio }
}

fun main5() {
    val carrito = Carrito()
    carrito += Producto("pan", 1.5)
    carrito += Producto("leche", 0.9)

    println(carrito["pan"])
    println("queso" in carrito)
    println(carrito.total())
}




//A9

class Tienda {
      lateinit var cliente :String

        val catalogo: List<String> by lazy {
               println("Cargando catálogo...")
               listOf("pan", "leche", "queso")
           }
}

fun main6() {
    val tienda = Tienda()
    tienda.cliente = "Ana"
    println("Hola, ${tienda.cliente}")
    println(tienda.catalogo)
    println(tienda.catalogo.size)
}