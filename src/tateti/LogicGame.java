/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tateti;

import java.awt.Color;
import javax.swing.JOptionPane;



/**
 *
 * @author German Medina https://github.com/germanchopp
 */
public class LogicGame {
    int turn;
    int sX;
    int sO;
    
    public void resetScore (){
        setsX(0);
        setsO(0);
    
    }
    
    
    
    
    
    
    
    public LogicGame(int turn, int sX, int sO) {
        this.turn = turn;
        this.sX = sX;
        this.sO = sO;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getsX() {
        return sX;
    }

    public void setsX(int sX) {
        this.sX = sX;
    }

    public int getsO() {
        return sO;
    }

    public void setsO(int sO) {
        this.sO = sO;
    }
    
    public void swap(){
        if(getTurn()==0){
            setTurn(1);
        } else{
            setTurn(0);
        } 
    }
    
    public int game(int matrix[][]){
        //horizontal possibilities
        if(matrix[0][0] == matrix [0][1] && matrix[0][0] == matrix[0][2]){
        return 1;
    }
        if(matrix[1][0] == matrix [1][1] && matrix[1][0] == matrix[1][2]){
        return 2;
    }
        if(matrix[2][0] == matrix [2][1] && matrix[2][0] == matrix[2][2]){
        return 3;
    }
        //vertical possibilities
        if(matrix[0][0] == matrix [1][0] && matrix[0][0] == matrix[2][0]){
        return 4;
    }
        if(matrix[0][1] == matrix [1][1] && matrix[0][1] == matrix[2][1]){
        return 5;
    }
        if(matrix[0][2] == matrix [1][2] && matrix[0][2] == matrix[2][2]){
        return 6;
    }
        //diagonal possibilities
        if(matrix[0][0] == matrix [1][1] && matrix[0][0] == matrix[2][2]){
        return 7;
    }
        if(matrix[2][0] == matrix [1][1] && matrix[2][0] == matrix[0][2]){
        return 8;
    }
                    
        return 0;        
    }
    
    public int play(javax.swing.JButton bt, int i, int j, int matrix[][], javax.swing.JLabel pX, javax.swing.JLabel pO){
        
        matrix[i][j] = getTurn();
        
        String n = new String();
        
        if(getTurn() == 0){
           n="X";
           bt.setForeground(Color.red);
        }else{
            n="O";
            bt.setForeground(Color.blue);
        }
        
        swap();
        bt.setText(n);
        bt.setEnabled(false);
        
        if (game(matrix)!=0){
            JOptionPane.showMessageDialog(null,"You Win "+n);
            if(getTurn()==1){
                setsX(getsX()+1);
                pX.setText(String.valueOf(getsX()));
            }
            if(getTurn()==0){
                setsO(getsO()+1);
                pO.setText(String.valueOf(getsO()));
            }
        return 1;
        }    
        return 0;
    }
    
    public void scratch(int matrix[][], javax.swing.JLabel p, int n, int i, int j){
        matrix[i][j]=getTurn();
        
        if(game(matrix)==n){
            p.setVisible(true);
        }
    }
    
}
