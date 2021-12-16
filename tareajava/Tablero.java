package tareajava;

public class Tablero{
    public Ramo Semestre[] = new Ramo[2];
    public int horas_disponibles;
    public Mano mano;
    public String bufos_en_juego[] = new String[3];

    public Tablero(Ramo[] Semestre, int horas_disponibles) {
        this.Semestre = Semestre;
        this.horas_disponibles = horas_disponibles;
    }


    /**
    * jugarEstudio:
    * juega la carta estudio
    *
    * @param estudio Estudio: la carta Estudio que se juega
    * @param pos int: la posicion del ramo en el semestre al que se le juega la carta Estudio
    * @return void.
    */
    public void jugarEstudio(Estudio estudio, int pos){
        if(horas_disponibles < estudio.costo){
            System.out.println("NO TIENES SUFICIENTES HORAS DISPONIBLES PARA JUGAR LA CARTA DE ESTUDIO");
            return;
        }
        this.Semestre[pos].anadirEstudio(estudio, this);
    }


    /**
    * mostrarTablero:
    * muestra los ramos del semestre y las cartas jugadas en estas
    *
    * @return void.
    */
    public void mostrarTablero(){
        System.out.println("*****************************************************");
        System.out.println("***************INFORMACION DEL TABLERO***************");
        System.out.println("*****************************************************\n");
        for(int i = 0;i<2;i++){
            if(this.Semestre[i]==null){
                continue;
            }
            this.Semestre[i].mostrarCarta();
            for(int j=0;j<6;j++){
                if(this.Semestre[i].estudios[j] instanceof Estudio){
                    this.Semestre[i].estudios[j].mostrarCarta();
                    System.out.println("\n");
                }
            }
            
        }
        System.out.println("\n");
    }

}