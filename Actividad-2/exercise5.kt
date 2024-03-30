/*Sistema de Gestión de Biblioteca: Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces:
Material: Una clase base abstracta que tiene propiedades como titulo, autor, anioPublicacion,  y un método abstracto para mostrarDetalles().
Libro: Una subclase de Material que tiene propiedades adicionales como género, número páginas y un método para mostrar los detalles del libro.
Revista: Una subclase de Material que tiene propiedades como issn, volumen, número, editorial y un método para mostrar los detalles de la revista.
Usuario: Una clase que tiene propiedades como nombre, apellido, edad y métodos para reservar y devolver materiales.
Biblioteca: Una clase que gestiona los materiales disponibles, los usuarios registrados y las operaciones de préstamo y devolución.
Crear instancias de las subclases y ejecutar las operaciones de área y perímetro para cada instancia. 

Autor: Kevin Chambilla
Creación: 29/03/2024
 */

// Clase abstracta Material
abstract class Material(val tit: String, val aut: String, val anioPub: Int) {
    abstract fun mostrarDetalles()
}

// Subclase Libro de Material
class Libro(tit: String, aut: String, anioPub: Int, val gen: String, val numPag: Int) : Material(tit, aut, anioPub) {
    override fun mostrarDetalles() {
        println("Libro:")
        println("Título: $tit")
        println("Autor: $aut")
        println("Año de Publicación: $anioPub")
        println("Género: $gen")
        println("Número de Páginas: $numPag")
    }
}

// Subclase Revista de Material
class Revista(tit: String, aut: String, anioPub: Int, val iss: String, val vol: Int, val num: Int, val edit: String) : Material(tit, aut, anioPub) {
    override fun mostrarDetalles() {
        println("Revista:")
        println("Título: $tit")
        println("Autor: $aut")
        println("Año de Publicación: $anioPub")
        println("ISSN: $iss")
        println("Volumen: $vol")
        println("Número: $num")
        println("Editorial: $edit")
    }
}

// Interfaz para Usuario
interface Usuario {
    val nom: String
    val ape: String
    val ed: Int

    fun reservarMaterial(mat: Material)
    fun devolverMaterial(mat: Material)
}

//implementacion de la interfaz Usuario
class AccionUsuario(override val nom: String, override val ape: String, override val ed: Int) : Usuario {
    override fun reservarMaterial(mat: Material) {
        println("$nom $ape ha reservado el siguiente material:")
        mat.mostrarDetalles()
    }

    override fun devolverMaterial(mat: Material) {
        println("$nom $ape ha devuelto el siguiente material:")
        mat.mostrarDetalles()
    }
}

// Clase Biblioteca
class Biblioteca {
    private val matsDisp = mutableListOf<Material>()
    private val ususReg = mutableListOf<Usuario>()

    fun agregarMaterial(mat: Material) {
        matsDisp.add(mat)
    }

    fun registrarUsuario(usu: Usuario) {
        ususReg.add(usu)
    }

    fun prestarMaterial(mat: Material, usu: Usuario) {
        if (matsDisp.contains(mat) && ususReg.contains(usu)) {
            println("Se ha prestado el siguiente material a ${usu.nom} ${usu.ape}:")
            mat.mostrarDetalles()
            matsDisp.remove(mat)
        } else {
            println("No se puede prestar el material. Verifique que el material esté disponible y el usuario esté registrado.")
        }
    }

    fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles en la biblioteca:")
        matsDisp.forEach { it.mostrarDetalles(); println("-------------") }
    }

    fun mostrarUsuariosRegistrados() {
        println("Usuarios registrados en la biblioteca:")
        ususReg.forEach { println("Nombre: ${it.nom} ${it.ape}, Edad: ${it.ed}"); println("-------------") }
    }
}

fun main() {
    val lib1 = Libro("CUentos", "Paulo Gomez", 1988, "Novela", 197)
    val lib2 = Libro("Cien años", "Gabriel", 1967, "Realismo", 432)
    val rev1 = Revista("National Geographic", "Varios", 2022, "ISSN12345", 150, 3, "National Geographic")

    val usu1 = AccionUsuario("Kevin", "Chambilla", 18)
    val usu2 = AccionUsuario("Fernanda", "Ventura", 23)

    val biblio = Biblioteca()

    biblio.agregarMaterial(lib1)
    biblio.agregarMaterial(lib2)
    biblio.agregarMaterial(rev1)

    biblio.registrarUsuario(usu1)
    biblio.registrarUsuario(usu2)

    println("------- Materiales Disponibles -------")
    biblio.mostrarMaterialesDisponibles()

    println("\n------- Usuarios Registrados -------")
    biblio.mostrarUsuariosRegistrados()

    usu1.reservarMaterial(lib1)
    biblio.prestarMaterial(rev1, usu2)

    println("\n------- Materiales Disponibles Después de Préstamos -------")
    biblio.mostrarMaterialesDisponibles()
}