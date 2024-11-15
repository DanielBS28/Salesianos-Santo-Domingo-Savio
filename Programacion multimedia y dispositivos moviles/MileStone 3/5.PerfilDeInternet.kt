fun main() {
    val amanda = Persona("Amanda", 33, "jugar al tenis", null)
    val atiqah = Persona("Atiqah", 28, "escalar", amanda)

    amanda.mostrarPerfil()
    atiqah.mostrarPerfil()
}

class Persona(val nombre: String, val edad: Int, val pasatiempo: String?, val referido: Persona?) {
    fun mostrarPerfil() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        if(pasatiempo != null) {
            print("Le gusta $pasatiempo. ")
        }
        if(referido != null) {
            print("Tiene un referente llamado ${referido.nombre}")
            if(referido.pasatiempo != null) {
                print(", a quien le gusta ${referido.pasatiempo}.")
            } else {
                print(".")
            }
        } else {
            print("No tiene un referente.")
        }
        print("\n\n")
    }
}