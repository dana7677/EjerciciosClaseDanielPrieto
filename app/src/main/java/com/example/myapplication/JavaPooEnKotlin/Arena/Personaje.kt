package com.example.myapplication.JavaPooEnKotlin.Arena

import android.widget.Switch



public fun setStatsPorClase(miClase:Clase): ModeloPersonaje
{

    var vidaPasar = 0.0f;
        when (miClase) {
            Clase.GUERRERO -> vidaPasar = 12.0f;
            Clase.ARQUERO -> vidaPasar = 12.0f;
            Clase.MAGO -> vidaPasar = 12.0f;
            else -> { // Note the block
                vidaPasar = 0.0f;
                print("No es valido")
            }
        }
    var dmgPasar = 0.0f;
    when (miClase) {
        Clase.GUERRERO -> dmgPasar = 12.0f;
        Clase.ARQUERO -> dmgPasar = 12.0f;
        Clase.MAGO -> dmgPasar = 12.0f;
        else -> { // Note the block
            dmgPasar = 0.0f;
            print("No es valido")
        }
    }
    var manaPasar = 0.0f;
    when (miClase) {
        Clase.GUERRERO -> manaPasar = 12.0f;
        Clase.ARQUERO -> manaPasar = 12.0f;
        Clase.MAGO -> manaPasar = 12.0f;
        else -> { // Note the block
            manaPasar = 0.0f;
            print("No es valido")
        }
    }
    var statsPasar = ModeloPersonaje(nombre ="Default" ,dmg =dmgPasar , health=vidaPasar,mana=manaPasar);

    return statsPasar
}

class Personaje(miClase: Clase,nombreInicial: String)
{

    val clasePersonaje = miClase;
    val statsBase = setStatsPorClase(clasePersonaje) ;
    val nombre=statsBase.nombre;
    val dmg = statsBase.dmg;
    val health = statsBase.health;
    val mana = statsBase.mana;

    public fun inicio()
    {

    }
    public fun ataque()
    {


    }
}