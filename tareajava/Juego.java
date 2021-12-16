package tareajava;
import java.util.Scanner;
//revertir el buff de los Estudios

public class Juego {
    public Mazo mazo_carrera;
    public Mazo mazo_Universidad;
    public Tablero tablero;
    public int aprobados;
    public int reprobados;
    public Mano mano;

    
    public Juego(Mazo mazo_carrera, Mazo mazo_Universidad, 
            Tablero tablero, int aprobados,
            int reprobados, Mano mano) {
        this.mazo_carrera = mazo_carrera;
        this.mazo_Universidad = mazo_Universidad;
        this.tablero = tablero;
        this.aprobados = aprobados;
        this.reprobados = reprobados;
        this.mano = mano;
    }

    public static void main(String[] args) {
        //remover Semestre al final del turno en calcular nota
        Mazo mazo_Carrera = new Mazo(2);
        Mazo mazo_Universidad = new Mazo(1);
        Ramo Semestre[] = new Ramo[2];
        Tablero tablero = new Tablero(Semestre, 12);
        int aprobados = 0;
        int reprobados = 0;
        Carta cartas[] = new Carta[6];
        Mano mano = new Mano(cartas);
        Juego juego = new Juego(mazo_Carrera, mazo_Universidad, tablero, aprobados, reprobados, mano);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("\t\tBIENVENIDO AL JUEGO DE CARRERA! SUERTE!");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("PODRAS PASAR 4 RAMOS Y LLEGAR A LA VICTORIA ROYAL, O REPROBARAS 2 RAMOS \n\t\t\t  Y PERECERAS?");
        while((juego.reprobados) < 2 && (juego.aprobados) < 4){//juego
            juego.tablero.horas_disponibles = 12;
            juego.mano.debuff(juego.tablero); //quita los bufos de las cartas estudio, si tienen
            for(int i=0;i<6;i++){ //robar cartas hasta tener 6 al inicio de cada turno
                if(juego.mano.cartas[i]==null){
                    mazo_Universidad.draw(tablero, mano);
                }
            }
            mazo_Carrera.draw(tablero, mano); //pone los Semestre en el tablero hasta tener 2
            boolean flag = true;
            while(flag){
                //mueve todas las cartas null(usadas) al final de la mano
                for(int i=0;i<6;i++){
                    if (juego.mano.cartas[i] == null) {
                        for(int k=i;k<6;k++){
                            if(juego.mano.cartas[k]!=null){
                                juego.mano.cartas[i] = juego.mano.cartas[k];
                                juego.mano.cartas[k] = null;
                                break;
                            }
                        }
                    }
                }  
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\tTUS POSIBLES ENTRADAS SON:\n\n\tCARTA \t\t\t-para jugar una carta\n\tMANO\t\t\t-para mostrar la mano\n\tTABLERO\t\t\t-para mostrar el tablero\n\tTERMINAR TURNO  \t-para terminar el turno (duh...)\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("HORAS RESTANTES: " + juego.tablero.horas_disponibles + "\n");
                System.out.println("RAMOS APROBADOS: " + juego.aprobados + "\n");
                System.out.println("RAMOS REPROBADOS: " + juego.reprobados + "\n");
                System.out.println("BUFOS ACTIVOS:");
                for(int g = 0;g<3;g++){
                    if(juego.tablero.bufos_en_juego[g]!=null){
                        System.out.println("\t" + juego.tablero.bufos_en_juego[g]);
                    }
                }
                System.out.println("");
                Scanner myObj_juego = new Scanner(System.in);
                String jugada = myObj_juego.nextLine();
                System.out.println("\n");
                switch (jugada) {
                    case "CARTA":
                        Scanner myObj_juego_pos = new Scanner(System.in);
                        System.out.println("QUE CARTA JUGAR [1-6]");
                        int pos_carta = (Integer.parseInt(myObj_juego_pos.nextLine()))-1;
                        Scanner myObj_juego_0 = new Scanner(System.in);
                        if(pos_carta>5 || pos_carta<0){
                            System.out.println("ESA POSICION NO ES VALIDA");
                            break;
                        }
                        if(juego.mano.cartas[pos_carta]==null){
                            System.out.println("NO HAY CARTA EN ESA POSICION");
                            break;
                        }
                        if (juego.mano.cartas[pos_carta] instanceof Estudio) {
                            System.out.println("SOBRE QUE RAMO APLICAR ESTUDIO? [1-2]");
                            int pos_ramo = Integer.parseInt(myObj_juego_0.nextLine())-1;
                            if(pos_ramo<0 || pos_ramo>1){
                                System.out.println("ESA POSICION NO ES VALIDA");
                                break;
                            }
                            if (juego.tablero.Semestre[pos_ramo] != null) {
                                juego.tablero.jugarEstudio((Estudio)juego.mano.cartas[pos_carta], pos_ramo);
                                for(int i = 0;i<6;i++){
                                    if(juego.mano.cartas[i]==(Estudio)(juego.mano.cartas[pos_carta])){
                                        juego.mano.cartas[i]=null;
                                    }
                                }
                                break;
                            }
                            if (juego.tablero.Semestre[pos_ramo] == null) {
                                System.out.println("CUIDADO, NO HAY RAMO EN ESTA POSICION");
                                break;
                            }
                        }
                        else{
                            if (juego.mano.cartas[pos_carta] instanceof Evento) {
                                ((Evento)juego.mano.cartas[pos_carta]).aplicarEvento(tablero, mazo_Carrera, mano);
                            } 
                        }
                        break;
                    case "MANO":
                        juego.mano.mostrarMano();
                        break;
                    case "TABLERO":
                        juego.tablero.mostrarTablero();
                        break;
                    case "TERMINAR TURNO":
                        flag = false;
                        break;
                }
            }
            for(int k = 0;k<2;k++){
                if(juego.tablero.Semestre[k]==null){
                    continue;
                }
                juego.tablero.Semestre[k].calcularnota(juego.tablero.Semestre[k], juego);
                juego.tablero.Semestre[k] = null;
            }
        }
        if(juego.reprobados>=2){
            System.out.println("PERDISTE! F\n");
            System.out.println("RAMOS APROBADOS: " + juego.aprobados);
            System.out.println("RAMOS REPROBADOS: " + juego.reprobados + "\n");
        }
        else{
            System.out.println("GANASTE! POGGERS\n");
            System.out.println("RAMOS APROBADOS: " + juego.aprobados);
            System.out.println("RAMOS REPROBADOS: " + juego.reprobados + "\n");
        }
        System.out.println("PULSA CUALQUIER LETRA (Y ENTER) PARA SALIR DEL PROGRAMA. NOS VEMOS!");
        Scanner myObj_salida = new Scanner(System.in);
        myObj_salida.nextLine();
        myObj_salida.close();
        System.exit(0);
    }
}
