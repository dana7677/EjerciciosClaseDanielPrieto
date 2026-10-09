package com.example.myapplication.JavaPooEnKotlin.Arena

import android.R
import android.widget.Switch

sealed class ResultadoAtaque {
    data class Impacto(val danio: Float) : ResultadoAtaque()
    data object SinRecursos : ResultadoAtaque()
    data object ObjetivoFueraDeCombate : ResultadoAtaque()
    data object PersonajeFueraDeCombate : ResultadoAtaque()
}


public fun setStatsPorClase(miClase:Clase): ModeloPersonaje
{

    var vidaPasar = 0.0f;
        when (miClase) {
            Clase.GUERRERO -> vidaPasar = 120.0f;
            Clase.ARQUERO -> vidaPasar = 100.0f;
            Clase.MAGO -> vidaPasar = 80.0f;
            Clase.CLERIGO -> vidaPasar = 10.0f;
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
        Clase.CLERIGO -> dmgPasar = 15.0f;
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
        Clase.CLERIGO -> manaPasar = 80.0f;
        else -> { // Note the block
            manaPasar = 0.0f;
            print("No es valido")
        }
    }
    var statsPasar = ModeloPersonaje(nombre ="Default" ,dmg =dmgPasar , health=vidaPasar,mana=manaPasar);

    return statsPasar
}

class Personaje(miClase: Clase,nombreInicial: String,flechasPasar:Int,puedeCurarPasar: Boolean)
{

    val clasePersonaje = miClase;
    val statsBase = setStatsPorClase(clasePersonaje) ;
    var nombre=nombreInicial;
    var dmg = statsBase.dmg;
    var health = statsBase.health;
    var flechas = flechasPasar;
    var mana = statsBase.mana;
    var fueraDeCombate =false;
    var puedeCurar = puedeCurarPasar;

    fun mostrarResultado(resultado: ResultadoAtaque) {

        when (resultado) {
            is ResultadoAtaque.Impacto ->
                println("El ataque ha impactado y hace ${resultado.danio} de daño")
            ResultadoAtaque.SinRecursos ->
                println("No quedan recursos para atacar")
            ResultadoAtaque.ObjetivoFueraDeCombate ->
                println("El objetivo está fuera de combate")
            ResultadoAtaque.PersonajeFueraDeCombate ->
                println("Tu personaje está fuera de combate")
        }
    }
    fun ataque(personajeObjetivo: Personaje):ResultadoAtaque {

        if (fueraDeCombate==true) {
            print(nombre + "Fuera de combate no puede atacar")
            return ResultadoAtaque.PersonajeFueraDeCombate
        }
        else
        {
            when (clasePersonaje) {

                Clase.GUERRERO -> {
                    if(personajeObjetivo.fueraDeCombate==true)
                    {
                        return ResultadoAtaque.ObjetivoFueraDeCombate
                    }
                    else
                    {
                        personajeObjetivo.recibirDmg(dmg, false)
                        println(
                            nombre + " golpea con la espada a " + personajeObjetivo.nombre +
                                    " ("+dmg+ ") -> " + personajeObjetivo.printEstado()
                        )

                        return ResultadoAtaque.Impacto(dmg);
                    }



                }

                Clase.ARQUERO -> {
                    if(personajeObjetivo.fueraDeCombate==true)
                    {
                        return ResultadoAtaque.ObjetivoFueraDeCombate
                    }
                    else if (flechas <= 0) {
                        println(nombre + " No quedan flechas")
                        return ResultadoAtaque.SinRecursos
                    } else {
                        personajeObjetivo.recibirDmg(dmg, false)
                        flechas= flechas-1;

                        println(
                            nombre + " dispara una flecha a " + personajeObjetivo.nombre +
                                     "( "+dmg+"quedan " + flechas + ") -> " +
                                    personajeObjetivo.printEstado()
                        )
                        return ResultadoAtaque.Impacto(dmg);
                    }
                }

                Clase.MAGO, Clase.CLERIGO -> {
                    if(personajeObjetivo.fueraDeCombate==true)
                    {
                        return ResultadoAtaque.ObjetivoFueraDeCombate
                    }
                    else if (mana < 20) {
                        println(nombre + " No queda maná")
                        return ResultadoAtaque.SinRecursos
                    } else {
                        personajeObjetivo.recibirDmg(dmg, false)
                        mana -= 20.0f

                        println(
                            nombre + " lanza un hechizo a " + personajeObjetivo.nombre +
                                    " ("+dmg +" maná " + mana + ") -> " +
                                    personajeObjetivo.printEstado()
                        )

                        return ResultadoAtaque.Impacto(dmg);
                    }
                }

                else -> {
                    print("No es válido")
                    return ResultadoAtaque.PersonajeFueraDeCombate
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
        if(puedeCurar==true && fueraDeCombate!=true)
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