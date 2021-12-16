package tareajava;

import java.util.Scanner;
public class Evento extends Carta{
    private evento_juego poder;
    public Evento(String nombre, String lore, evento_juego PODER) {
        super(nombre, lore);
        this.poder = PODER;
    }
    /**
    * MostrarCarta:
    * * muestra la carta Evento por pantalla mediante sysout.
    * @return void.
    */
    public void mostrarCarta() {
        System.out.println("Evento: Poder: " + poder + "\n" + "Nombre: " + nombre + "\n" + "Lore: " + lore + "\n");
    }

    /**
    * aplicarEvento:
    * consiste en un switch para cada tipo de evento (5).
    * Para BUFF se manipula BonusMax y BonusMin
    * Para RAV se hace un putback de la carta y se borra del semestre
    * Para CC se usa mathrandom y se manipulan los creditos.
    * NOTA: si usamos CC y luego RAV los creditos vuelven a su cantidad original.
    * Luego se borra la carta de la mano
    * tambien se agrega el bufo(si evento es un buff) a los bufos_en_juego para mostrarlos por pantalla
    * @param tablero Tablero:es el tablero del juego para tener acceso a los Semestre.
    * @param mazo_Carrera Mazo:Mazo donde estan los Semestre del juego.
    * @param mano Mano: mano del jugador
    * @return void.
    */
    public void aplicarEvento(Tablero tablero, Mazo mazo_Carrera, Mano mano){
        switch (this.poder) {
            case BUFF_MATEMATICO:
            //recorremos la mano y vemos las carta y aumentamos bonus max y min si es que es de la area
                for(int i = 0;i<6;i++){
                    if(mano.cartas[i]!=null){
                        if(mano.cartas[i] instanceof Estudio){
                            if(((Estudio)mano.cartas[i]).area == Area.MATEMATICO){
                                ((Estudio)mano.cartas[i]).bonusMax *= 1.25;
                                ((Estudio)mano.cartas[i]).bonusMin *= 1.25;
                                ((Estudio)mano.cartas[i]).buff = 1; //para checkear despues porque hay que revertir
                            }
                        }
                    }
                }
                for(int k = 0;k<3;k++){
                    if(tablero.bufos_en_juego[k]==null){
                        tablero.bufos_en_juego[k] = "BUFO MATEMATICO";
                        break;
                    }

                }
                break;
            case BUFF_INFORMATICO:
                for(int i = 0;i<6;i++){
                    if(mano.cartas[i]!=null){
                        if(mano.cartas[i] instanceof Estudio){
                            if(((Estudio)mano.cartas[i]).area == Area.INFORMATICO){
                                ((Estudio)mano.cartas[i]).bonusMax *= 1.25;
                                ((Estudio)mano.cartas[i]).bonusMin *= 1.25;
                                ((Estudio)mano.cartas[i]).buff = 1; //para checkear despues porque hay que revertir
                            }
                        }
                    }
                }
                for(int k = 0;k<3;k++){
                    if(tablero.bufos_en_juego[k]==null){
                        tablero.bufos_en_juego[k] = "BUFO INFORMATICO";
                        break;
                    }

                }
                break;
            case BUFF_HUMANISTICO:
                for(int i = 0;i<6;i++){
                    if(mano.cartas[i]!=null){
                        if(mano.cartas[i] instanceof Estudio){
                            if(((Estudio)mano.cartas[i]).area == Area.HUMANISTICO){
                                ((Estudio)mano.cartas[i]).bonusMax *= 1.25;
                                ((Estudio)mano.cartas[i]).bonusMin *= 1.25;
                                ((Estudio)mano.cartas[i]).buff = 1; //para checkear despues porque hay que revertir
                            }
                        }
                    }
                }
                for(int k = 0;k<3;k++){
                    if(tablero.bufos_en_juego[k]==null){
                        tablero.bufos_en_juego[k] = "BUFO HUMANISTICO";
                        break;
                    }

                }
                break;
            case RAV:
                //preguntar la posicion del ramo
                Scanner myObj = new Scanner(System.in);
                System.out.println("CUAL ES LA POSICION DEL RAMO AL QUE QUIERES HACER RAV? [1,2]");
                int pos = Integer.parseInt(myObj.nextLine())-1;
                //los 2 if de abajo son para que no se vayan a RAV ramos que tengan ajuste en creditos por CC
                if (pos != 1 && pos != 0) {
                    System.out.println("CUIDADO, NO HAY RAMO EN ESTA POSICION");
                    break;
                }
                if(tablero.Semestre[pos].ajuste == 1){
                    tablero.Semestre[pos].ajuste = 0;
                    tablero.Semestre[pos].creditos -= 3;
                }

                if(tablero.Semestre[pos].ajuste == -1){
                    tablero.Semestre[pos].ajuste = 0;
                    tablero.Semestre[pos].creditos += 3;
                }
                
                mazo_Carrera.putBack(tablero.Semestre[pos], tablero);
                break;
            case CAMBIO_COORDINACION:
                Scanner myObj_cc = new Scanner(System.in);
                System.out.println("CUAL ES LA POSICION DEL RAMO AL QUE QUIERES HACER CC? [1,2]");
                int pos_cc = Integer.parseInt(myObj_cc.nextLine())-1;
                if(pos_cc != 1 && pos_cc != 0){
                    System.out.println("CUIDADO, NO HAY RAMO EN ESTA POSICION");
                    break;
                }
                int randomizador = (int) (Math.random()*2); //0 o 1

                if(randomizador == 1){ // +3 creditos ajuste cambia a 1
                    tablero.Semestre[pos_cc].creditos += 3;
                    tablero.Semestre[pos_cc].ajuste = 1;
                    System.out.println("¡LOS CREDITOS DEL RAMO " + tablero.Semestre[pos_cc].nombre + " AN AUMENTADO EN 3!\n");
                }
                else{ // -3 creditos ajuste cambia a -1
                    tablero.Semestre[pos_cc].creditos -= 3;
                    tablero.Semestre[pos_cc].ajuste = -1;
                    System.out.println("¡LOS CREDITOS DEL RAMO " + tablero.Semestre[pos_cc].nombre + " AN DISMINUIDO EN 3!\n");
                }
                break;
        }
        for(int i = 0;i<5;i++){
            if(mano.cartas[i]==this){
                mano.cartas[i]=null;
            }

        }

    }

}
