fun main() {
    val niño = 5
    val adulto = 28
    val anciano = 87

    val esLunes = true

    println("El precio de la entrada de cine para una persona de $niño años es \$${precioEntrada(niño, esLunes)}.")
    println("El precio de la entrada de cine para una persona de $adulto años es \$${precioEntrada(adulto, esLunes)}.")
    println("El precio de la entrada de cine para una persona de $anciano años es \$${precioEntrada(anciano, esLunes)}.")
}

fun precioEntrada(edad: Int, esLunes: Boolean): Int {
    return when(edad) {
        in 0..12 -> 15
        in 13..60 -> if (esLunes) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}