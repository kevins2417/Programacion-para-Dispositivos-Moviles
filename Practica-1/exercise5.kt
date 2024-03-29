/*Piedra, Papel, Tijera. Escriba un programa que realice el juego de piedra, papel o tijera.
La computadora debe elegir de manera aleatoria la opción a elegir. Después debe preguntar al usuario
que opción quiere. Imprimir si ganó, perdió o empató.

Autor: Kevin Chambilla
Creación: 27/03/2024
*/
import kotlin.random.Random

fun main(){
    val Aleatorio = Random.nextInt(1, 31)
    var intentos = 5
    var adivinado = false

    println("Adivina un número entre 1 y 30.")

    while (intentos > 0 && !adivinado) {
        println("Intentos restantes: $intentos")
        println("Ingresa tu número:")
        val numero = readLine()?.toIntOrNull()

        if (numero != null) {
            if (numero == Aleatorio) {
                println("Ganaste adivinaste el número $Aleatorio!")
                adivinado = true
            } else if (numero < Aleatorio) {
                println("El número es mayor.")
            } else {
                println("El número es menor.")
            }

            intentos--
        } else {
            println("ingresa un número válido.")
        }
    }

    if (!adivinado) {
        println("Game Over El número era: $Aleatorio")
    }

}