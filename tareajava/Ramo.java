package tareajava;

public class Ramo extends Carta{
    public Ramo(String nombre, String lore, int creditos, Area area) {
        super(nombre, lore);
        this.area = area;
        this.creditos = creditos;
        this.ajuste = 0;

    }

    public int creditos;
    public Estudio estudios[] = new Estudio[6];
    public Area area;
    public int ajuste;


    /**
    * calcularnota:
    * revisa cada carta de estudio y la agrega a la nota final
    * la nota final va de 0 a 100
    * @param ramo Ramo: el ramo al que se le calcula la nota final
    * @param juego Juego: llamamos al juego para actualizar los ramos aprobados y reprobados
    * @return int: la nota final del ramo
    */
    public int calcularnota(Ramo ramo, Juego juego){
        int nota_final = 0;
        int resta = 2*ramo.creditos;
        Area area_ramo = ramo.area;

        for(int i = 0;i<6;i++){
            if ((ramo.estudios[i])!=null){
                if((ramo.estudios[i]).area == area_ramo){
                    int randomizador = (int) (Math.random() * ((ramo.estudios[i]).bonusMax - (ramo.estudios[i]).bonusMin) + (ramo.estudios[i]).bonusMin);
                    nota_final += (randomizador)*1.25 ;
                }
                else{
                    int randomizador = (int) (Math.random() * ((ramo.estudios[i]).bonusMax - (ramo.estudios[i]).bonusMin) + (ramo.estudios[i]).bonusMin);
                    nota_final += randomizador;
                }
            }
        }
        nota_final -= resta;
        if(nota_final > 100){
            nota_final = 100;
        }
        if(nota_final < 0){
            nota_final = 0;
        }
        if(nota_final < 55){
            juego.reprobados += 1;
        }
        if(nota_final>=55){
            juego.aprobados += 1;
        }
        return nota_final;
    }


    /**
    * anadirEstudio:
    * agrega una carta Estudio a las cartas jugadas en el ramo
    *
    * @param estudio Estudio:la carta que se agrega al ramo
    * @param tablero Tablero: tablero del juego se llama para restar las horas restantes.
    * @return void.
    */
    public void anadirEstudio(Estudio estudio, Tablero tablero){
        for(int i=0;i<6;i++){
            if(this.estudios[i]==null){
                this.estudios[i] = estudio;
                tablero.horas_disponibles -= estudio.costo;
                System.out.println("HORAS RESTANTES: " + tablero.horas_disponibles);
                break;
            }
        }
    }


    /**
    * MostrarCarta:
    * muestra la carta ramo y sus cartas jugadas por pantalla mediante sysout.
    * @return void.
    */
    public void mostrarCarta() {
        System.out.println("RAMO EN JUEGO:  " + this.nombre + "\n\t\t" + this.lore +"\n");
        System.out.println("\tCARTAS JUGADAS EN " + this.nombre + ": ");
        System.out.println("\n");
    }


}

