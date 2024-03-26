/*Piedra, Papel, Tijera. Escriba un programa que realice el juego de piedra, papel o tijera.
La computadora debe elegir de manera aleatoria la opción a elegir. Después debe preguntar al usuario
que opción quiere. Imprimir si ganó, perdió o empató.

Autor: Kevin Chambilla
Creación: 26/03/2024
 */
fun main() {
    val opcion = arrayOf("piedra", "papel", "tijera")
    val random = java.util.Random()

    val pc = opcion[random.nextInt(opcion.size)]

    println("Elige una opción (piedra, papel o tijera):")
    val person = readLine()?.toLowerCase()

    if (person in opcion) {
        println("La pc eligió: $pc")
        println("elegiste: $person")

        if (person == pc) {
            println("empate")
        } else if ((person == "piedra" && pc == "tijera") ||
            (person == "papel" && pc == "piedra") ||
            (person == "tijera" && pc == "papel")
        ) {
            println("Ganaste")
        } else {
            println("Perdiste")
        }
    } else {
        println("Opción no válida")
    }
}