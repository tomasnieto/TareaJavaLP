package tareajava;

enum Area {
    HUMANISTICO, MATEMATICO, INFORMATICO;
    }
enum evento_juego {
    RAV, BUFF_INFORMATICO, BUFF_MATEMATICO, BUFF_HUMANISTICO, CAMBIO_COORDINACION;
    }
public abstract class Carta {
    public String nombre;
    public String lore;
    /**
    * mostrarCarta:
    * metodo abstracto para Ramo, Evento y Estudio.
    * @return void.
    */
    public abstract void mostrarCarta();
    public Carta(String nombre, String lore) {
        this.nombre = nombre;
        this.lore = lore;
    }
}

