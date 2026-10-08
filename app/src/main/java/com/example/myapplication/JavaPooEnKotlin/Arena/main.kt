package com.example.myapplication.JavaPooEnKotlin.Arena

fun main()
{
    var personaje1 = Personaje(Clase.GUERRERO,"Conan",0);
    var personaje2 = Personaje(Clase.MAGO,"Merlin",0)
    var personaje3 = Personaje(Clase.ARQUERO,"Robin",3)

    print("=== Estado Inicial === \n")
    println(personaje1.printEstado())
    println(personaje2.printEstado())
    println(personaje3.printEstado())
    print("\n === Combate === \n")
    personaje1.ataque(personaje2)
    personaje3.ataque(personaje1)
    personaje3.ataque(personaje1)
    personaje3.ataque(personaje1)

    personaje2.curar(personaje1)
    personaje2.ataque(personaje3)
    personaje2.ataque(personaje3)
    personaje2.ataque(personaje3)
    personaje2.ataque(personaje3)

    personaje1.ataque(personaje3)
    personaje1.ataque(personaje3)
    personaje1.ataque(personaje3)

    personaje3.ataque(personaje1)

    print("\n \n === ¿Quien puede curar? === \n")
    personaje1.printCanHealth()
    personaje2.printCanHealth()
    personaje3.printCanHealth()
    print("\n === Estado final === \n")

    println(personaje1.printEstado())
    println(personaje2.printEstado())
    println(personaje3.printEstado())


}