/*Estadística Alumnos. Preguntar cuántos alumnos hay en un salon.
Preguntar la edad de cada uno de ellos. Mostrar la edad máxima y mínima.
Imprimir lo siguiente. NOTA: No usar listas.
Ejemplo: 25 Alumnos
=== Edades ===
Máximo = 25
Mínimo = 22
Todos = 20,21, 22, 23, 25, …, 20

Autor: Kevin Chambilla
Creación: 27/03/2024
 */
fun main(){
    println("Cantidad de alumnos:")
    val alumnos = readLine()?.toIntOrNull()

	//verifica si la cantidad de alumnos es diferente de cero e inicializa el valor minimo y maximo.
    if (alumnos != null && alumnos > 0){
        var edadmax = Int.MIN_VALUE
        var edadmin = Int.MAX_VALUE
        var esp = ""

		//solicita la edad de cada alumno
        for (i in 1..alumnos){
            println("edad del alumno$i")
            val edad = readLine()?.toIntOrNull()
			
			//identifica la edad minima y maxima
            if (edad != null){
                if (edad > edadmax){
                    edadmax = edad
                }
                if (edad < edadmin){
                    edadmin = edad
                }
				
				// hace la cadena de todas las edades
                esp += if (i == alumnos){
                    "$edad"
                } else {
                    "$edad, "
                }
            } else {
                println("no válido")
            }
        }

        println("===Edades===")
        println("Máximo = $edadmax")
        println("Minimo = $edadmin")
        println("Todos = $esp")
    }
}