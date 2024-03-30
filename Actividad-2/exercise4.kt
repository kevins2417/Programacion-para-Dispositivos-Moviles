/*Cree una clase abstracta “shape” la cual contenga las propiedades área, perímetro y las funciones para calcular estos valores e imprimir el resultado de cada operación.
Adicional crea tres subclases cuadrado, círculo y rectángulo que reciban los valores de sus lados, el radio en el caso del círculo con constructores secundarios y heredando la clase “shape” y sus métodos.
Crear instancias de las subclases y ejecutar las operaciones de área y perímetro para cada instancia.

Autor: Kevin Chambilla
Creación: 29/03/2024
 */

// Clase abstracta Shape
abstract class Shape {
    // Propiedad abstracta para ser implementada para circulo, cuadrado y rectangulo
    abstract val area: Double
    abstract val perimetro: Double

    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

// Subclase Cuadrado que calcula el área y el perimetro del cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override val area: Double
        get() = lado * lado

    override val perimetro: Double
        get() = 4 * lado
}

// Subclase Circulo que calcula el área y el perimetro del circulo
class Circulo(val radio: Double) : Shape() {
    override val area: Double
        get() = 3.14 * radio * radio

    override val perimetro: Double
        get() = 2 * 3.14 * radio
}

// Subclase Rectangulo que calcula el área y el perimetro del rectangulo
class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override val area: Double
        get() = base * altura

    override val perimetro: Double
        get() = 2 * (base + altura)
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    println("Cuadrado:")
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    println("\nCírculo:")
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    println("\nRectángulo:")
    rectangulo.imprimirResultados()
}