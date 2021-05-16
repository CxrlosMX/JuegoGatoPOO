/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegogatopoo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CxrlosMX
 */
public class Uso_juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0, a = 0, op = 0;
        String v;
        Tablero tablero = new Tablero();
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "*-*-JUEGO DEL GATO-*-*-\n1.-Iniciar Juego\n2.-Salir"));
                switch (op) {
                    case 1: {
                        String nombre1 = JOptionPane.showInputDialog(null, "Introduce el nombre del primer jugador por favor", "Introduciendo nombre", JOptionPane.INFORMATION_MESSAGE);
                        Jugador j1 = new Jugador(nombre1, "O");
                        String nombre2 = JOptionPane.showInputDialog(null, "Introduce el nombre del segundo jugador por favor", "Introduciendo nombre", JOptionPane.INFORMATION_MESSAGE);
                        Jugador j2 = new Jugador(nombre2, "X");
                        boolean encontrado = false;
                        do {
                            encontrado = false;
                            tablero.mostrarTablero();
                            do {
                                v = JOptionPane.showInputDialog(null, "Turno de " + nombre1, "Introduciendo posicion", JOptionPane.INFORMATION_MESSAGE);
                                a = Integer.parseInt(v);
                                if (a >= 1 && a <= 9) {
                                    encontrado = true;
                                    tablero.elegirCasilla(v, j1);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", JOptionPane.ERROR_MESSAGE);
                                }
                            } while (!encontrado);
                            encontrado = false;
                            if (tablero.ganador(j1)) {
                                JOptionPane.showMessageDialog(null, "Jugador Ganador " + j1.toString(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                                tablero.mostrarTablero();
                                n = 10;
                            }

                            if (!tablero.ganador(j1)) {
                                tablero.mostrarTablero();
                                do {
                                    v = JOptionPane.showInputDialog(null, "Turno de " + nombre2, "Introduciendo posicion", JOptionPane.INFORMATION_MESSAGE);
                                    a = Integer.parseInt(v);
                                    if (a >= 1 && a <= 9) {
                                        tablero.elegirCasilla(v, j2);
                                        encontrado = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", JOptionPane.ERROR_MESSAGE);

                                    }
                                } while (!encontrado);
                            }
                            if (tablero.ganador(j2)) {
                                JOptionPane.showMessageDialog(null, "Jugador Ganador " + j2.toString(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                                tablero.mostrarTablero();
                                n = 10;
                            }
                            n++;

                        } while (n < 9);
                        if (n == 9) {
                            JOptionPane.showMessageDialog(null, "Ningun Ganador", "Juego Empatado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }
                    case 2: {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Uso_juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null, "Juego cerrado", "Juego Cerrado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce valores validos por favor", "Error de valores", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de valores", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 2);
    }
}
