/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reforco;

/**
 *
 * @author milena
 */
public class Cell {
    int r;
    int valor;
    double valorUp;
    double valorDown;
    double valorLeft;
    double valorRight;

    public Cell(int r, int valor, double valorUp, double valorDown, double valorLeft, double valorRight) {
        this.r = r;
        this.valor = valor;
        this.valorUp = valorUp;
        this.valorDown = valorDown;
        this.valorLeft = valorLeft;
        this.valorRight = valorRight;
    }
    
    
}
