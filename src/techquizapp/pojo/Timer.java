/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author hp
 */
public class Timer {

    synchronized public void timer(){
        try{
                for(int i = 60; i <= 0; i--){
                    //lblTimer.setText("" + i +" sec" );
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException ex){
                System.out.println("Exception");
                ex.printStackTrace();
            }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
