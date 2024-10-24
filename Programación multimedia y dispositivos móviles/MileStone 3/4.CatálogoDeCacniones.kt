fun main() {
    val cancionBruno = Cancion("No Se Habla de Bruno", "Reparto de Encanto", 2022, 1_000_000)
    cancionBruno.imprimirDescripcion()
    println(cancionBruno.esPopular)
}

class Cancion(
    val titulo: String,
    val artista: String,
    val anoPublicacion: Int,
    val cantidadReproducciones: Int
){
    val esPopular: Boolean
        get() = cantidadReproducciones >= 1000

    fun imprimirDescripcion() {
        println("$titulo, interpretada por $artista, fue lanzada en $anoPublicacion.")
    }
}
