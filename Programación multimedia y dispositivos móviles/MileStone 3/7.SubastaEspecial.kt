fun main() {
    val ofertaGanadora = Oferta(5000, "Coleccionista Privado")

    println("El artículo A se vendió por ${precioSubasta(ofertaGanadora, 2000)}.")
    println("El artículo B se vendió por ${precioSubasta(null, 3000)}.")
}

class Oferta(val monto: Int, val postor: String)

fun precioSubasta(oferta: Oferta?, precioMinimo: Int): Int {
    return oferta?.monto ?: precioMinimo
}