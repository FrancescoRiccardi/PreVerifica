/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica;

/**
 *
 * @author Francesco
 */
import java.util.Random;

/**
 *
 * @author franc
 */
public class ThGenera extends Thread {
    private DatiCondivisi ptrDati;
    private int num;
    
    public ThGenera(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
    }

    public ThGenera() {
    }
    
    public void run(){
        int f = 0;
        for (int i=0; i < num; i++){
            Random rand = new Random();
            f = rand.nextInt(100)+1;
            ptrDati.waitGen();
            ptrDati.setBuffer(f);
            System.out.println("Generato " + f);
            ptrDati.signMax();
        }
        System.out.println("Fine di ThGenera");
    }
}
