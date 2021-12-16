Nombre: Tomas Santiago Nieto Guerrero
Rol:201973529-2

Mi juego se corre con los dos comandos de makefile:
       make                        //para compilar
       make run                    //para ejecutar el juego

notas sobre el juego(jugabilidad):

    cada vez que se juega una carta de la mano, la mano se ordena tal que deja todas las
    cartas null(usadas) al final del array. Esto es para una mejor experiencia, ya que
    el usuario no se tiene que memorizar que espacios de la mano estan vacios.

    Las posiciones validas como input son del 1-6. Para mejor experiencia de usuario,
    en vez de ingresar del 0 al 5. Lo mismo ocurre con las posiciones de los ramos en 
    el tablero.

    por favor no introducir nada que no sea un numero cuando son pedidos.
    el scanner espera un int por el parse de integer.

    abajo del ramo se muestra su lore, un simple texto que hace referencia al ramo de alguna manera.


       COMANDO DEL JUGADOR:
       CARTA: CARTA es para avisarle al juego que quieres jugar una carta, despues el juego tiene
              preguntara cual carta quieres jugar.

       MANO: MANO muestra las cartas de tu mano en orden.

       TABLERO: muestra los ramos en juego y las cartas jugadas en cada una.

       TERMINAR TURNO: termina el turno, es decir calcula las notas finales de cada ramo en el tablero
                     y luego actualiza los ramos aprobados y reprobados. tambien se roba cartas hasta
                     tener 6 en la mano(automatico).

