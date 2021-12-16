package tareajava;

public class Mazo {
    public int numero_cartas;
    public Carta cartas[];
    public int posSiguienteCarta;

    public Mazo(int caso){
        if(caso == 1){
            this.cartas = new Carta[25];
            this.numero_cartas = 25;
            this.posSiguienteCarta = 0;
            crearMazoUniversidad();
            shuffle();
        }
        else{
            this.numero_cartas = 10;
            this.cartas = new Carta[10];
            this.posSiguienteCarta = 0;
            crearMazoCarrera();
            shuffle();
        }
    }


    /**
    * crearMazoUniversidad:
    * crea el mazo universitario
    *
    * @return void.
    */
    public void crearMazoUniversidad() {
        cartas[0] = new Estudio("StackOverFlow", "patrimonio cultural de la humanidad", 90, 20, 4, Area.INFORMATICO);// epica
        cartas[1] = new Estudio("hola mundo", "no se que poner aca xd", 40, 28, 3, Area.INFORMATICO);// rara
        cartas[2] = new Estudio("tutorial con acento americano", "lloras. De felicidad", 40, 28, 3, Area.INFORMATICO);// rara
        cartas[3] = new Estudio("Alan turing", "Si. Puedes invocar a Alan Turing", 40, 28, 3, Area.INFORMATICO);// rara
        cartas[4] = new Estudio("Tutorial con acento indio", "lloras. mucho", 26, 18, 2, Area.INFORMATICO);// comun
        cartas[5] = new Estudio("redbull", "tus ojos se inyectan de sangre", 26, 18, 2, Area.INFORMATICO);// comun
        cartas[6] = new Estudio("cafe", "simple cafe para todas ocasiones", 26, 18, 2, Area.INFORMATICO);// comun
        cartas[7] = new Estudio("te", "tecito para calmar el alma", 26, 18, 2, Area.INFORMATICO);// comun

        cartas[8] = new Estudio("Wolphram", "Alfa as fuck", 90, 20, 4, Area.MATEMATICO);// epica
        cartas[9] = new Estudio("Geogebra 3D", "util sobre todo en mate 4", 40, 28, 3, Area.MATEMATICO);// rara
        cartas[10] = new Estudio("Symbolab", "util en todas las mates", 40, 28, 3, Area.MATEMATICO);// rara
        cartas[11] = new Estudio("JulioProfe", "ayuda bastante en mate 1", 26, 18, 2, Area.MATEMATICO);// comun
        cartas[12] = new Estudio("Hacer la guia", "No tiene las respuestas al final. oh no.", 26, 18, 2,
                Area.MATEMATICO);// comun
        cartas[13] = new Estudio("Leer los PDF de las clases", "Demostrando... Desmostrando...", 26, 18, 2,
                Area.MATEMATICO);// comun

        cartas[14] = new Estudio("r/philosophy", "Donde se juntas las mentes maestras de nuestra generacion", 90, 20, 4,
                Area.HUMANISTICO);// epcia
        cartas[15] = new Estudio("documental de WWII", "Hitler y Stalin se aman <3", 40, 28, 3, Area.HUMANISTICO);// rara
        cartas[16] = new Estudio("easyessay.com", "autogenerador de trabajos, cuando no hay otra salida", 40, 28, 3,
                Area.HUMANISTICO);// rara
        cartas[17] = new Estudio("Wikipedia", "simple pero efectivo", 26, 18, 2, Area.HUMANISTICO);// comun
        cartas[18] = new Estudio("leer paper", "La letra es especialmente chica", 26, 18, 2, Area.HUMANISTICO);// comun
        cartas[19] = new Estudio("chamullo", "vivir para chamullar, chamullar para vivir", 26, 18, 2, Area.HUMANISTICO);// comun

        cartas[20] = new Evento("RAV", "Why are we still here? Just to suffer?", evento_juego.RAV);// RAV
        cartas[21] = new Evento("rodilleras informaticas", "succ", evento_juego.BUFF_INFORMATICO);// BUFF INFORMATICO
        cartas[22] = new Evento("rodilleras matematicas", "succ", evento_juego.BUFF_MATEMATICO);// BUFF MATEMATICO
        cartas[23] = new Evento("rodilleras humanisticas", "succ", evento_juego.BUFF_HUMANISTICO);// BUFF HUMANISTICO
        cartas[24] = new Evento("Cambio de Coordinacion", "usm be like", evento_juego.CAMBIO_COORDINACION);// CC
    }


    /**
    * crearMazoCarrera:
    * crea el mazo de carrera
    *
    * @return void.
    */
    public void crearMazoCarrera() {
        cartas[0] = new Ramo("TALF", "Our whole universe was in a hot, dense state...", 5, Area.INFORMATICO);
        cartas[1] = new Ramo("EDD", "C mamo", 5, Area.INFORMATICO);
        cartas[2] = new Ramo("DISCRETAS", "G R A F O S", 5, Area.INFORMATICO);
        cartas[3] = new Ramo("PROGRAMACION", "welcome to pitonia", 5, Area.INFORMATICO);

        cartas[4] = new Ramo("MAT021", "limit pi -> 3 = e", 7, Area.MATEMATICO);
        cartas[5] = new Ramo("MAT022", "sqrt(g) = pi", 7, Area.MATEMATICO);
        cartas[6] = new Ramo("MAT023", "sea |x|<0", 7, Area.MATEMATICO);

        cartas[7] = new Ramo("ETICA", "Vivimos en una sociedad", 2, Area.HUMANISTICO);
        cartas[8] = new Ramo("SOCIEDAD", "Vivimos en una sociedad", 2, Area.HUMANISTICO);
        cartas[9] = new Ramo("ESTETICA", "Vivimos en una sociedad", 2, Area.HUMANISTICO);
    }


    /**
    * shuffle:
    * "revuelve" el mazo. se divide en casos para mazo de carrera o universitario
    *
    * @return void.
    */
    public void shuffle() {
        int posAleaotoria;
        Carta c;
        if(this.numero_cartas == 25){
            for (int i = 0; i < 25; i++) {
                posAleaotoria = (int) (Math.random() * 25);
                c = cartas[i];
                cartas[i] = cartas[posAleaotoria];
                cartas[posAleaotoria] = c;
            }
        }
        else{
            for (int i = 0; i < 10; i++) {
                posAleaotoria = (int) (Math.random() * 10);
                c = cartas[i];
                cartas[i] = cartas[posAleaotoria];
                cartas[posAleaotoria] = c;
            }
        }
    }


    /**
    * draw:
    * DescripcionDeLaFuncion
    *
    * @param tablero Tablero: para el caso donde se tiene que poner la carta ramo
    * en el Semestre
    * @param mano Mano: para el caso donde se tiene que poner la carta en la mano.
    * @return void.
    */
    public void draw(Tablero tablero, Mano mano){
        if(this.numero_cartas == 25){
            mano.anadirCarta(this.cartas[posSiguienteCarta]);
            posSiguienteCarta++;
        }
        else{
            for(int i = 0;i<2;i++){
                if(tablero.Semestre[i] == null){
                    tablero.Semestre[i] = (Ramo) this.cartas[posSiguienteCarta];
                    posSiguienteCarta++;
                }
            }
        }
    }

    /**
    * putBack:
    * Mete un ramo en el fondo del mazo de la carrera
    *
    * @param carta Carta: la carta que se mete al fondo del mazo y se borrar el ramo del Semestre
    * @param tablero Tablero: tablero del juego donde se borra el ramo del Semestre
    * @return void.
    */
    public void putBack(Carta carta, Tablero tablero){
        int index = 0;
        for(int i = 0;i<10;i++){
            if(this.cartas[i] == carta){
                index = i;
                break;
            }
        }
        for(int i = index;i<10;i++){
            if(i == 10-1){
                this.cartas[10-1] = carta;
            }
            else{
                this.cartas[i] = this.cartas[i+1];
            }
        }
        for(int i = 0;i<2;i++){
            if(tablero.Semestre[i] == carta){
                tablero.Semestre[i] = null;
                break;
            }
        }
        posSiguienteCarta--; 
    }
}

