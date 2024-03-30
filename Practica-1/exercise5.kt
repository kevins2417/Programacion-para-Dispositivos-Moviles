/*Adivina Número. Escribe un programa que genere un número aleatorio entre 1 y 30, luego pida al usuario que adivine el número.
Proporciona pistas indicando si el número a adivinar es mayor o menor que el número ingresado por el usuario.
Continúa solicitando intentos hasta que el usuario adivine correctamente el número.Tienes 5 intentos, si se acaba debe imprimir game over.
De lo contrario mostrar un mensaje de felicitación por ganar el juego.

Autor: Kevin Chambilla
Creación: 27/03/2024
*/

//se importa la clase Random de la biblioteca de Kotlin
import kotlin.random.Random

fun main(){
	//se genera un número aleatorio entre 1 y 30
    val Aleatorio = Random.nextInt(1, 31)
    var intentos = 5
    var adivinado = false

    println("Adivina un número entre 1 y 30.")

	//bucle para permitir los 5 intentos
    while (intentos > 0 && !adivinado) {
        println("Intentos restantes: $intentos")
        println("Ingresa tu número:")
        val numero = readLine()?.toIntOrNull()

		//se comprueba si el número ingresado es igual al aleatorio y se brinda las pistas
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