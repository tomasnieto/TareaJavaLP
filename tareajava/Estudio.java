package tareajava;

public class Estudio extends Carta{
    public Estudio(String nombre, String lore, int bonusMax, int bonusMin, int costo, Area area) {
        super(nombre, lore);
        this.area = area;
        this.bonusMax = bonusMax;
        this.bonusMin = bonusMin;
        this.costo = costo;
        this.buff = 0;
    }
    public int bonusMin;
    public int bonusMax;
    public Area area;
    public int costo;
    public int buff;
    /**
    * MostrarCarta:
    * muestra la carta Estudio por pantalla mediante sysout.
    * @return void.
    */
    public void mostrarCarta() {
        System.out.println("Carta de Estudio: \nnombre: " + nombre+ "\nlore: " + lore +"\narea: " + area + "\nbonusMax = " + bonusMax + "\nbonusMin = " + bonusMin + "\ncosto = " + costo + "\n");
    }
}

