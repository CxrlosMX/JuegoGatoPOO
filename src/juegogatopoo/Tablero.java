/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegogatopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 14/05/2021
 *
 */
public class Tablero {

    private String[][] tablero = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    public Tablero() {

    }

    //Metodo para seleccionar casilla
    public void elegirCasilla(String valor, Jugador a) {
        boolean encontrado = false;

        for (int i = 0; i < tablero.length && !encontrado; i++) {//
            for (int j = 0; j < this.tablero[0].length && !encontrado; j++) {
                if (!tablero[i][j].equalsIgnoreCase("X") || !tablero[i][j].equalsIgnoreCase("O")) {
                    if (tablero[i][j].equalsIgnoreCase(valor)) {
                        tablero[i][j] = a.getSimbolo();
                        encontrado = true;
                    }
                }
            }

        }
        if (!encontrado) {
            System.out.println("Casilla ya ocupada");
        }
    }

    public boolean nOcupada(Jugador a) {
        boolean encontrado = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].equalsIgnoreCase(a.getSimbolo())) {
                    return true;
                }
            }
        }
        return false;
    }
    /*if (ganador(a)) {
     System.out.println("Juego terminado");
            
     }*/

    //Metodo para mostrar el tablero
    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Metodo para verificar si han ganado
    public boolean hayGanador(Jugador a) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].equalsIgnoreCase(a.getSimbolo()) && tablero[i][j].equalsIgnoreCase(a.getSimbolo()) && tablero[i][j].equalsIgnoreCase(a.getSimbolo())) {
                    System.out.println("Jugador ganador " + a.toString());
                    return true;
                }

            }
        }
        return false;
    }

    public boolean ganador(Jugador a) {
        if (tablero[0][0].equalsIgnoreCase(a.getSimbolo()) && tablero[0][1].equalsIgnoreCase(a.getSimbolo()) && tablero[0][2].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[1][0].equalsIgnoreCase(a.getSimbolo()) && tablero[1][1].equalsIgnoreCase(a.getSimbolo()) && tablero[1][2].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[2][0].equalsIgnoreCase(a.getSimbolo()) && tablero[2][1].equalsIgnoreCase(a.getSimbolo()) && tablero[2][2].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[0][0].equalsIgnoreCase(a.getSimbolo()) && tablero[1][0].equalsIgnoreCase(a.getSimbolo()) && tablero[2][0].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[0][1].equalsIgnoreCase(a.getSimbolo()) && tablero[1][1].equalsIgnoreCase(a.getSimbolo()) && tablero[2][1].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[0][2].equalsIgnoreCase(a.getSimbolo()) && tablero[1][2].equalsIgnoreCase(a.getSimbolo()) && tablero[2][2].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[0][0].equalsIgnoreCase(a.getSimbolo()) && tablero[1][1].equalsIgnoreCase(a.getSimbolo()) && tablero[2][2].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        } else if (tablero[0][2].equalsIgnoreCase(a.getSimbolo()) && tablero[1][1].equalsIgnoreCase(a.getSimbolo()) && tablero[2][0].equalsIgnoreCase(a.getSimbolo())) {

            return true;

        }
        return false;
    }

}
