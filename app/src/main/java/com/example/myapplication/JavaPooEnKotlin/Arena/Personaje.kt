package com.example.myapplication.JavaPooEnKotlin.Arena

import android.R
import android.widget.Switch



public fun setStatsPorClase(miClase:Clase): ModeloPersonaje
{

    var vidaPasar = 0.0f;
        when (miClase) {
            Clase.GUERRERO -> vidaPasar = 120.0f;
            Clase.ARQUERO -> vidaPasar = 100.0f;
            Clase.MAGO -> vidaPasar = 80.0f;
            else -> { // Note the block
                vidaPasar = 0.0f;
                print("No es valido")
            }
        }
    var dmgPasar = 0.0f;
    when (miClase) {
        Clase.GUERRERO -> dmgPasar = 15.0f;
        Clase.ARQUERO -> dmgPasar = 10.0f;
        Clase.MAGO -> dmgPasar = 20.0f;
        else -> { // Note the block
            dmgPasar = 0.0f;
            print("No es valido")
        }
    }
    var manaPasar = 0.0f;
    when (miClase) {
        Clase.GUERRERO -> manaPasar = 12.0f;
        Clase.ARQUERO -> manaPasar = 12.0f;
        Clase.MAGO -> manaPasar = 60.0f;
        else -> { // Note the block
            manaPasar = 0.0f;
            print("No es valido")
        }
    }
    var statsPasar = ModeloPersonaje(nombre ="Default" ,dmg =dmgPasar , health=vidaPasar,mana=manaPasar);

    return statsPasar
}

class Personaje(miClase: Clase,nombreInicial: String,flechasPasar:Int)
{

    val clasePersonaje = miClase;
    val statsBase = setStatsPorClase(clasePersonaje) ;
    var nombre=nombreInicial;
    var dmg = statsBase.dmg;
    var health = statsBase.health;
    var flechas = flechasPasar;
    var mana = statsBase.mana;
    var fueraDeCombate =false;

    fun ataque(personajeObjetivo: Personaje): Float {

        if (fueraDeCombate==true) {
            print(nombre + "Fuera de combate no puede atacar")
            return 0.0f
        }
        else
        {
            when (clasePersonaje) {

                Clase.GUERRERO -> {
                    personajeObjetivo.recibirDmg(dmg, false)

                    println(
                        nombre + " golpea con la espada a " + personajeObjetivo.nombre +
                                " (-15) -> " + personajeObjetivo.printEstado()
                    )

                    return dmg
                }

                Clase.ARQUERO -> {
                    if (flechas <= 0) {
                        println(nombre + " No quedan flechas")
                        return 0.0f
                    } else {
                        personajeObjetivo.recibirDmg(dmg, false)
                        flechas= flechas-1;

                        println(
                            nombre + " dispara una flecha a " + personajeObjetivo.nombre +
                                    " (-10, quedan " + flechas + ") -> " +
                                    personajeObjetivo.printEstado()
                        )

                        return dmg
                    }
                }

                Clase.MAGO -> {
                    if (mana < 20) {
                        println(nombre + " No queda maná")
                        return 0.0f
                    } else {
                        personajeObjetivo.recibirDmg(dmg, false)
                        mana -= 20.0f

                        println(
                            nombre + " lanza un hechizo a " + personajeObjetivo.nombre +
                                    " (-20, maná " + mana + ") -> " +
                                    personajeObjetivo.printEstado()
                        )

                        return dmg
                    }
                }

                else -> {
                    print("No es válido")
                    return 0.0f
                }
            }

        }


    }
    public fun curar(personajeObjetivo: Personaje): Float
    {

        if(clasePersonaje == Clase.MAGO && fueraDeCombate!=true)
        {
            personajeObjetivo.recibirDmg(15.0f,true)
            println(nombre+" cura a "+ personajeObjetivo.nombre + "(+15) -> "+ personajeObjetivo.printEstado())
            return 15.0f;
        }
        else
        {
            return 0.0f;
        }
        printEstado();

    }

    public fun printEstado():String
    {
           return (nombre+ "("+health+"/"+statsBase.health+")")

    }
    public fun printCanHealth()
    {
        if(clasePersonaje == Clase.MAGO && fueraDeCombate!=true)
        {
            println(nombre+" puede curar")
        }
        else
        {
            println(nombre+" no puede curar")
        }

    }

    public fun recibirDmg(dmgRecibido:Float,cura: Boolean)
    {

        if(cura==true)
        {
            if(health+dmgRecibido>statsBase.health)
            {
                health = statsBase.health;
            }
            else
            {
                health += dmgRecibido;
            }

        }
        else
        {
            if(health<=dmgRecibido)
            {
                fueraDeCombate=true;
                health =0.0f;
            }
            else
            {
                health -= dmgRecibido;
            }
        }
        printEstado();

    }
}