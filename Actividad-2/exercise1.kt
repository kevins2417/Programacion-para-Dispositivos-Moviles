/*Clase para Cuenta Bancaria: Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro.
Implementa métodos set y get para establecer y obtener el saldo, y añade un método para realizar retiros que tenga en cuenta el límite de retiro.
Utilice el set para validar datos.

Autor: Kevin Chambilla
Creación: 28/03/2024
 */

class CuentaBancaria(private var saldo: Double, private val limite: Double) {

    //Obtenemos el saldo, establecemos el saldo y verificamos que tenga saldo
    var saldop: Double

        get() = saldo
        set(value) {
            if (value > 0) {
                saldo = value
            } else {
                println("No hay saldo")
            }
        }

    // Método para realizar retiros, verificamos que el monto esté dentro del limite y haya saldo suficiente
    fun Retiro(monto: Double) {
        if (monto > 0 && monto <= limite && monto <= saldop) {
            saldo -= monto
            println("Retiro exitoso. Nuevo saldo: $saldop")
        } else {
            println("No se puede realizar el retiro por limite de retiro o saldo insuficiente")
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)

    println("Saldo inicial: ${cuenta.saldop}")

    cuenta.Retiro(200.0)
    cuenta.Retiro(700.0)
}