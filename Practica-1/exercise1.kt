/*Evaluación Empleados. En una determinada empresa, sus empleados son evaluados cada seis meses.
Los puntos que pueden obtener en la evaluación comienzan en 0 y pueden ir aumentando hasta llegar
a 10, traduciéndose en mejores beneficios. Al final del problema se muestra una tabla con los niveles
correspondientes a cada puntuación. La cantidad de dinero conseguida en cada nivel  se calcula multiplicando
el salario mensual por la  división de la puntuación del nivel divida entre 10. Escribir un programa que lea
la puntuación del usuario y su salario mensual e imprima su nivel de rendimiento, así como la cantidad de dinero
que recibirá el usuario. Ejemplo: Salario 10,000; Puntuación 8. Dinero = 10,000 * (8/10)= 8000. Resultado: Nivel
de Rendimiento Aceptable, Cantidad de Dinero Recibido $8000.

Autor: Kevin Chambilla
Creación: 25/03/2024
 */
fun main() {
    println("Ingrese su puntuación:")
    val p = readLine()?.toIntOrNull()

    println("Ingrese su salario:")
    val g = readLine()?.toDoubleOrNull()
	
	//verifica si la puntuacion y el dinero son validos
    if (p != null && g != null) {
        val ni: String
        val di: Double
		
		//Determina el ivel de rendimiento basado en la puntuación ingresada
        when {
            p >= 0 && p <= 3 -> {
                ni = "Inaceptable"
            }
            p >= 4 && p <= 6 -> {
                ni = "Aceptable"
            }
            p >= 7 && p <= 10 -> {
                ni = "Meritorio"
            }
            else -> {
                ni = "Puntuación inválida"
            }
        }
		
        di = g * (p / 10.0)

        println("Nivel de Rendimiento: $ni")
        println("Cantidad de Dinero Recibido: $$di")
    } else {
        println("No válido")
    }
}