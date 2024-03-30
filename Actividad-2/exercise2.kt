/*Clase para Producto: Diseña una clase Producto que tenga un precio y un descuento aplicable.
Implementa métodos set y get para establecer y obtener el precio y el descuento, y añade un método para calcular el precio final después de aplicar el descuento.
Utilice el set para validar datos.

Autor: Kevin Chambilla.
Creación: 28/03/2024
 */

class Producto(private var precio: Double, private var descuento: Double) {

    //Obtenemos el precio, establecemos el precio y verificamos que no sea negativo
    var precio1: Double

        get() = precio
        set(value) {
            if (value >= 0) {
                precio = value
            } else {
                println("El precio no puede ser negativo.")
            }
        }

    //Obtenemos el descuento, establecemos el descuento y verificamos que el descuento sea entre el 1% y 100%
    var descuento1: Double

        get() = descuento
        set(value) {
            if (value > 0 && value <= 100) {
                descuento = value
            } else {
                println("El descuento debe estar entre 1% y 100%.")
            }
        }

    // Método para calcular el precio final después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        val precioConDescuento = precio * (1 - descuento / 100)
        return precioConDescuento
    }
}

fun main() {
    val producto = Producto(100.0, 10.0)

    println("Precio inicial: ${producto.precio1}")
    println("Descuento: ${producto.descuento1}%")

    val precioFinal = producto.calcularPrecioFinal()
    println("Precio final después del descuento: $precioFinal")
}