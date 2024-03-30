/*Diseña un sistema de alquiler de vehículos que incluya interfaces como
VehiculoAlquilable con métodos para alquilar y devolver un vehículo, y clases concretas como Coche y Moto
que implementen esta interfaz.

Autor: Kevin Chambilla
Creación: 29/03/2024
 */

// Interfaz para vehículos alquilables
interface VehiculoAlquilable {
    fun alquilar()
    fun devolver()
}

// Clase concreta Coche
class Coche(val modelo: String, val placa: String) : VehiculoAlquilable {
    var alquilado: Boolean = false

    override fun alquilar() {
        if (!alquilado) {
            alquilado = true
            println("Coche modelo $modelo con placa $placa ha sido alquilado.")
        } else {
            println("El coche ya está alquilado.")
        }
    }

    override fun devolver() {
        if (alquilado) {
            alquilado = false
            println("Coche modelo $modelo con placa $placa ha sido devuelto.")
        } else {
            println("El coche no está alquilado.")
        }
    }
}

// Clase concreta Moto
class Moto(val marca: String, val codigo: String) : VehiculoAlquilable {
    var alquilado: Boolean = false

    override fun alquilar() {
        if (!alquilado) {
            alquilado = true
            println("Moto marca $marca con código $codigo ha sido alquilada.")
        } else {
            println("La moto ya está alquilada.")
        }
    }

    override fun devolver() {
        if (alquilado) {
            alquilado = false
            println("Moto marca $marca con código $codigo ha sido devuelta.")
        } else {
            println("La moto no está alquilada.")
        }
    }
}

fun main() {
    val coche1 = Coche("Toyota Corolla", "ABC123")
    val moto1 = Moto("Honda", "DEF456")

    coche1.alquilar()
    coche1.alquilar()
    coche1.devolver()

    moto1.alquilar()
    moto1.devolver()
}