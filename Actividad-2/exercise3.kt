/*Sistema de Gestión de Empleados: Crea un sistema de gestión de empleados que incluya las siguientes clases:
- Empleado: Una clase base abstracta que tiene propiedades como nombre, apellido, edad, salario y un método abstracto calcularPago() para calcular el pago.
- EmpleadoTiempoCompleto: Una subclase de Empleado que tiene propiedades adicionales como horasTrabajadas, tarifaHora y un método para calcular el pago teniendo en cuenta las horas trabajadas.
- EmpleadoMedioTiempo: Una subclase de Empleado que tiene propiedades como horasTrabajadas, tarifaHora, diasTrabajados y un método para calcular el pago tomando en cuenta las horas y los días trabajados.
- Crear instancias de las subclases y ejecutar las operaciones para realizar las pruebas necesarias.

Autor: Kevin Chambilla
Creación: 28/03/2024
 */

// Clase abstracta Empleado
abstract class Empleado(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    private var salario: Double
) {
    var salario1: Double
        get() = salario
        protected set(value) {
            salario = value
        }

    // Método para calcular el pago
    abstract fun calcularPago(): Double
}

class EmpleadoTiempoCompleto(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    private var horasTrabajadas: Int,
    private var tarifaHora: Double
) : Empleado(nombre, apellido, edad, salario) {

    //Obtenemos las horas trabajadas, establecemos las horas trabajdas y verificamos que sean entre el rango de horas establecidas
    var horasTrabajadas1: Int
        get() = horasTrabajadas
        set(value) {
            if (value >= 0 && value <= 60) {
                horasTrabajadas = value
            } else {
                println("Las horas trabajadas deben estar entre 0 y 60.")
            }
        }

    // Método para calcular el pago con las horas trabajadas
    override fun calcularPago(): Double {
        return salario1 + horasTrabajadas * tarifaHora
    }
}

class EmpleadoMedioTiempo(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    private var horasTrabajadas: Int,
    private var tarifaHora: Double,
    private var diasTrabajados: Int
) : Empleado(nombre, apellido, edad, salario) {

    //Obtenemos las horas trabajadas, establecemos las horas trabajdas y verificamos que sean entre el rango de horas establecidas
    var horasTrabajadas2: Int
        get() = horasTrabajadas
        set(value) {
            if (value >= 0 && value <= 30) {
                horasTrabajadas = value
            } else {
                println("Las horas trabajadas deben estar entre 0 y 30.")
            }
        }

    //Obtenemos los dias trabajadas, establecemos los dias trabajdas y verificamos que sean entre los dias de la semana
    var diasTrabajados1: Int
        get() = diasTrabajados
        set(value) {
            if (value > 0 && value <= 6) {
                diasTrabajados = value
            } else {
                println("Los días trabajados deben estar entre 1 y 6.")
            }
        }

    // Método para calcular con las horas y los días trabajados
    override fun calcularPago(): Double {
        return salario1 + horasTrabajadas * tarifaHora * diasTrabajados
    }
}

fun main() {
    val empleadoTiempoCompleto = EmpleadoTiempoCompleto("Ronald", "Caceres", 30, 3000.0, 40, 24.0)
    println("Pago del empleado a tiempo completo: ${empleadoTiempoCompleto.calcularPago()}")

    val empleadoMedioTiempo = EmpleadoMedioTiempo("Maria", "Gonzalez", 25, 1500.0, 20, 12.0, 3)
    println("Pago del empleado a medio tiempo: ${empleadoMedioTiempo.calcularPago()}")

    //comprobar validación
    empleadoTiempoCompleto.horasTrabajadas1 = 10

    empleadoMedioTiempo.horasTrabajadas2 = 40
    empleadoMedioTiempo.diasTrabajados1 = -2
}