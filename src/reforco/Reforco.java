/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reforco;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
        
        double q = 0;
        String direcao = ""; 
        double maiorValor = 0;
        Cell [][]cellMat = {{new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                            {new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                            {new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0)},
                            {new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(0, 0, 0, 0, 0, 0), new Cell(10, 0, 0, 0, 0, 0)},
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
     
                System.out.println("########");
                for(int i=0; i<linha; i++){
                    for(int j=0; j<coluna; j++){
                        System.out.print(cellMat[i][j].valor);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                System.out.println("CHEGOUUUUUUU");

                /*System.out.println("########");
                for(int i=0; i<linha; i++){
                    for(int j=0; j<coluna; j++){
                        System.out.print("Up:"+cellMat[i][j].valorUp+"Down: "+cellMat[i][j].valorDown+"Left: "+cellMat[i][j].valorLeft+"Right: "+cellMat[i][j].valorRight);
                        System.out.print("/");
                    }
                    System.out.println();
                }*/
                
                pos_y = numberAleatorio.nextInt(linha); 
                pos_x = numberAleatorio.nextInt(coluna);
                cellMat[pos_y][pos_x].valor = 2;
                cellMat[vertical][horizontal].valor = 0;

                horizontal = pos_x;
                vertical = pos_y; 

                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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

            maiorValor = Math.max(cellMat[vertical][horizontal].valorRight, Math.max(cellMat[vertical][horizontal].valorLeft, Math.max(cellMat[vertical][horizontal].valorDown, cellMat[vertical][horizontal].valorUp)));
            
            if(maiorValor == 0) {
                do {
                    if(cellMat[vertical][horizontal].valor == 1){
                        horizontal = auxHorizontal;
                        vertical = auxVertical;
                    }
                    if(numberAleatorio.nextInt(2) == 0) {
                        do{
                            if(numberAleatorio.nextInt(2) == 0){
                                if(horizontal != 0){
                                    horizontal -= 1;
                                    direcao = "l";
                                }
                            } else {
                                if(horizontal != coluna-1){
                                    horizontal+=1;
                                    direcao = "r";
                                }
                            }
                        } while(auxHorizontal == horizontal);
                    } else {
                        do{
                            if(numberAleatorio.nextInt(2) == 0){
                                if(vertical != 0){
                                    vertical -= 1;
                                    direcao = "d";
                                }
                            } else {
                                if(vertical != linha-1){
                                    vertical+=1;
                                    direcao = "u";
                                }
                            }
                        } while(auxVertical == vertical);
                    }
                } while (cellMat[vertical][horizontal].valor == 1);
                cellMat[vertical][horizontal].valor = 2; 
            } else {
                if(cellMat[vertical][horizontal].valorRight >= cellMat[vertical][horizontal].valorLeft 
                        && cellMat[vertical][horizontal].valorRight >= cellMat[vertical][horizontal].valorUp 
                        && cellMat[vertical][horizontal].valorRight >= cellMat[vertical][horizontal].valorDown){
                    horizontal+=1;
                } else if(cellMat[vertical][horizontal].valorLeft >= cellMat[vertical][horizontal].valorRight 
                        && cellMat[vertical][horizontal].valorLeft >= cellMat[vertical][horizontal].valorUp 
                        && cellMat[vertical][horizontal].valorLeft >= cellMat[vertical][horizontal].valorDown){
                    horizontal-=1;
                } else if(cellMat[vertical][horizontal].valorUp >= cellMat[vertical][horizontal].valorRight 
                        && cellMat[vertical][horizontal].valorUp >= cellMat[vertical][horizontal].valorLeft 
                        && cellMat[vertical][horizontal].valorUp >= cellMat[vertical][horizontal].valorDown){
                    vertical+=1;
                } else {
                    vertical-=1;
                }
            }

            q = cellMat[vertical][horizontal].r + (0.9 * Math.max(cellMat[vertical][horizontal].valorRight, Math.max(cellMat[vertical][horizontal].valorLeft, Math.max(cellMat[vertical][horizontal].valorDown, cellMat[vertical][horizontal].valorUp))));
            
            if(direcao == "e")
                cellMat[auxVertical][auxHorizontal].valorLeft = q;
            else if(direcao == "r")
                cellMat[auxVertical][auxHorizontal].valorRight = q;
            else if(direcao == "d")
                cellMat[auxVertical][auxHorizontal].valorDown = q;
            else
                cellMat[auxVertical][auxHorizontal].valorUp = q;
        }
    }
    
}
