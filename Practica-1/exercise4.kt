/*Calculadora Elemental. Realizar una calculadora  básica suma, resta, multiplicación, división.
Debe imprimir un menú con las opciones incluyendo una opción salir. Validar que la opción esté disponible.
Imprimir resultados. Ejemplo de menú:
==== Menú ====
1. Suma
2. Resta
3. Multiplicación
4. División
5. Salir.

Autor: Kevin Chambilla
Creación: 27/03/2024
 */
fun main() {
    var continuar = true

	//función para realizar las operaciones
    fun Operacion(nombreOp: String, operacion: (Double, Double) -> Double) {
        println("=== $nombreOp ===")
        println("Ingrese el primer número:")
        val numero1 = readLine()?.toDoubleOrNull()

        if (numero1 == null) {
            println("Número no válido. Intente de nuevo.")
            return
        }

        println("Ingrese el segundo número:")
        val numero2 = readLine()?.toDoubleOrNull()

        if (numero2 == null) {
            println("Número no válido. Intente de nuevo.")
            return
        }

        val resultado = operacion(numero1, numero2)
        println("El resultado de la $nombreOp es: $resultado")
    }

	//menu para las operaciones que se requiera
    while (continuar) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        println("Seleccione una opción:")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                Operacion("Suma") { a, b -> a + b }
            }
            2 -> {
                Operacion("Resta") { a, b -> a - b }
            }
            3 -> {
                Operacion("Multiplicación") { a, b -> a * b }
            }
            4 -> {
                Operacion("División") { a, b ->
                    if (b != 0.0) a / b
                    else {
                        println("Error")
                        Double.NaN
                    }
                }
            }
            5 -> {
                continuar = false
                println("Saliendo de la calculadora")
            }
            else -> {
                println("Opción no válida. Por favor seleccione una opción del menú.")
            }
        }
    }
}