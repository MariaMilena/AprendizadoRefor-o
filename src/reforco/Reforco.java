/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reforco;

import java.util.Random;

/**
 *
 * @author milena
 */
public class Reforco {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 0 = caminho livre   =>   1 = caminho ocupado   =>   2 = jogador
        int linha = 4;
        int coluna = 4;
        Random numberAleatorio = new Random();
        int pos_y;
        int pos_x;
        int horizontal, auxHorizontal;
        int vertical, auxVertical;
        
        /*Cell [][]cellMatriz = new Cell[5][5];
        Cell cell = new Cell(0, 0, true, false, true, true);*/

        /*int [][]cellMat = {{0, 0, 0, 0},
                           {0, 1, 0, 0},
                           {0, 0, 1, 1},
                           {0, 0, 0, 0},
                          };*/
        
        Cell [][]cellMat = {{new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                            {new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                            {new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                            {new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                           };

        do {
            pos_y = numberAleatorio.nextInt(linha); 
            pos_x = numberAleatorio.nextInt(coluna);
        } while(cellMat[pos_y][pos_x].valor == 1);
        cellMat[pos_y][pos_x].valor = 2; // colocando jogador em uma posição aleatoria da matriz
        horizontal = pos_x;
        vertical = pos_y; 

        auxHorizontal = horizontal;
        auxVertical = vertical;
        
        while(true){
            if(horizontal == coluna-1 && vertical == linha-1){
                System.out.println("CHEGOUUUUUUU");
     
                pos_y = numberAleatorio.nextInt(linha); 
                pos_x = numberAleatorio.nextInt(coluna);
                cellMat[pos_y][pos_x].valor = 2;
                break;
            }
            System.out.println("########");
            for(int i=0; i<linha; i++){
                for(int j=0; j<coluna; j++){
                    System.out.print(cellMat[i][j].valor);
                    System.out.print(" ");
                }
                System.out.println();
            }
            cellMat[vertical][horizontal].valor = 0;
            auxHorizontal = horizontal;
            auxVertical = vertical;
            do {
                if(cellMat[vertical][horizontal].valor == 1){
                    horizontal = auxHorizontal;
                    vertical = auxVertical;
                }
                if(numberAleatorio.nextInt(2) == 0) {
                    do{
                        if(numberAleatorio.nextInt(2) == 0){
                            if(horizontal != 0)
                                horizontal -= 1;
                        } else {
                            if(horizontal != coluna-1)
                                horizontal+=1;
                        }
                    } while(auxHorizontal == horizontal);
                } else {
                    do{
                        if(numberAleatorio.nextInt(2) == 0){
                            if(vertical != 0)
                                vertical -= 1;
                        } else {
                            if(vertical != linha-1)
                                vertical+=1;
                        }
                    } while(auxVertical == vertical);
                }
            } while (cellMat[vertical][horizontal].valor == 1);
            cellMat[vertical][horizontal].valor = 2; 
        }
    }
    
}
