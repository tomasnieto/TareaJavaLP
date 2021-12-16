package tareajava;


public class Mano {
    public Carta cartas[] = new Carta[6];

    public Mano(Carta[] cartas) {
        this.cartas = cartas;
    }

    /**
    * mostrarMano:
    * Muestra cada carta de la mano por pantalla usando mostrarCarta().
    * @return void.
    */
    public void mostrarMano(){
        System.out.println("***************************************************");
        System.out.println("***************LAS CARTAS DE TU MANO***************");
        System.out.println("***************************************************\n");
        for(int i=0;i<6;i++){
            if (this.cartas[i] != null){
                System.out.println("------------------");
                this.cartas[i].mostrarCarta();
            }
        }
    }

    /**
    * anadirCarta:
    * agrega una carta al primer espacio no nulo de la mano 
    * @param carta Carta: la carta que se agrega a la mano
    * @return void.
    */
    void anadirCarta(Carta carta){
        for(int i = 0;i < 6;i++){
            if (this.cartas[i] == null){
                this.cartas[i] = carta;
                break;
            }
        }
    }

    /**
    * seleccionarCarta:
    * retorna la carta en la posicion pos
    * @param pos int: posicion de la carta en el array
    * @return Carta.
    */
    public Carta seleccionarCarta(int pos){
        return this.cartas[pos];
    }


    /**
    * debuff:
    * quita los buff de las carta estudio, si tienen
    * @return void.
    */
    public void debuff(Tablero tablero){
        int hum = 0;
        int mat = 0;
        int inf = 0;
        for(int i = 0;i<3;i++){
            if(tablero.bufos_en_juego[i]==null){
                continue;
            }
            switch (tablero.bufos_en_juego[i]) {
                case "BUFO MATEMATICO":
                    mat = 1;
                    break;
                case "BUFO HUMANISTICO":
                    hum = 1;
                    break;
                case "BUFO INFORMATICO":
                    inf = 1;
                    break;
            }
            tablero.bufos_en_juego[i]=null;
        }

        for(int j=0;j<6;j++){
            if(this.cartas[j]!=null){
                if(this.cartas[j] instanceof Estudio){
                    switch (((Estudio)this.cartas[j]).area) {
                        case MATEMATICO:
                            if(mat == 1){
                                ((Estudio)this.cartas[j]).bonusMax *= 0.8;
                                ((Estudio)this.cartas[j]).bonusMin *= 0.8;
                            }
                            break;
                    
                        case HUMANISTICO:
                            if(hum == 1){
                                ((Estudio)this.cartas[j]).bonusMax *= 0.8;
                                ((Estudio)this.cartas[j]).bonusMin *= 0.8;
                            }
                            break;

                        case INFORMATICO:
                            if(inf == 1){
                                ((Estudio)this.cartas[j]).bonusMax *= 0.8;
                                ((Estudio)this.cartas[j]).bonusMin *= 0.8;
                            }
                            break;
                    }
                }
            }
        }
    }

    /**
    * alinear:
    * mueve todos los espacios null de la mano hacia la izquiera
    * @return void.
    */
    public void alinear(){
        for(int i=0;i<6;i++){
            if (this.cartas[i] == null) {
                for(int k=i;k<6;k++){
                    if(this.cartas[k]!=null){
                        this.cartas[i] = this.cartas[k];
                        this.cartas[k]=null;
                    }
                }
            }
        }  
    }
}