package com.example.myapplication.EjerciciosPartePrimera

fun main() {
    //Ejercicio1

    var lista = listOf(1,2,3,4,5)

    for(elemento in lista)
    {
        println(elemento)
    }
    //Ejercicio2
    var listaNumerosEnteros = listOf(1,2,3,4,5,6,7,8,9,10)
    var sumaNumerosListaEnteros=0;
    for(elemento in listaNumerosEnteros)
    {
        sumaNumerosListaEnteros=sumaNumerosListaEnteros+elemento;
    }
    println("El valor de la suma de la lista de enteros es = "+ sumaNumerosListaEnteros)

    //Ejercicio3

    var listaNumerosEnterosOrdenar = listOf(1,21,32,46,15,65,37,8,9,10)
    var numeroMasGrande=0;
    for(elemento in listaNumerosEnterosOrdenar)
    {
        if(numeroMasGrande<elemento)
        {
            numeroMasGrande=elemento;
        }
    }
    println("El numero mas grande es ="+ numeroMasGrande)

    //Ejercicio 4

    val numeros: MutableList<Int> = mutableListOf(1,2,3,4,5)

    for(i in numeros.indices)
    {
        numeros[i]= numeros[i]*2;
        println(numeros[i])
    }

    //Ejercicio 5
    val numerosNuevos: MutableList<Int> = mutableListOf()

    for(elemento in listaNumerosEnterosOrdenar)
    {
        if(elemento %2 ==0)
        {
            numerosNuevos.add(elemento)
        }
    }
    println("La lista con los numeros pares"+ numerosNuevos)

    //Ejercicio 6
    val cadena1:List<String> =listOf("a","b","c")
    val cadena2 = listOf("d","e","f")
    val concatenacionCadenas: MutableList<String> = mutableListOf()
    for(elemento in cadena1)
    {
        concatenacionCadenas.add(elemento);
    }
    for(elemento in cadena2)
    {
        concatenacionCadenas.add(elemento);
    }

    println(concatenacionCadenas)

    //Ejercicio 7
    val numerosConMenores5 = mutableListOf(1,6,3,7,4,8);

    numerosConMenores5.removeIf { elemento->elemento>5 }
    println(numerosConMenores5)

    //Ejercicio 8
    val numerosParaSacarEl3 = listOf(3,1,3,4,3,5)
    println("Las veces que sale el 3 son "+numerosParaSacarEl3.count {elemento->elemento==3})

    //Ejercicio 9

    val listaOrdenNormal = mutableListOf(1,6,3,7,4,8);
    val listaInversa = listaOrdenNormal.reversed();
    println("Lista normal"+listaOrdenNormal + "\nLista Inversa" + listaInversa)

    //Ejercicio 10

    val listaNumerosParaQuitarpares = mutableListOf(1,11,13,4,2,32,51)
    listaNumerosParaQuitarpares.removeIf { element -> element % 2 == 0 }
    println("La suma de la lista de los impares es = " +listaNumerosParaQuitarpares.sum())

    //Ejercicio 11

    val animales = mutableListOf("perro","gato","perro","ratón")

    for(i in animales.indices)
    {
        if(animales[i].equals("perro"))
        {
            animales.set(i,"gato");
        }
    }
    println(animales)

    //Ejercicio 12

    val numerosConRepetidos = mutableListOf(1,2,3,5,1,2,6,3,666,2,3,6)
    val listaSinRepetidos = numerosConRepetidos.distinct()
    println("La lista con repetidos = "+numerosConRepetidos)
    println("La lista sin repetidos = "+ listaSinRepetidos)

    //Ejercicio 13




}