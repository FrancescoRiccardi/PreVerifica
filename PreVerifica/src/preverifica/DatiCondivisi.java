/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Francesco
 */
public class DatiCondivisi {
    private int buffer;
    private int max;
    private int num;
    private Semaphore syncMax;
    private Semaphore syncGen;

    public DatiCondivisi(int buffer, int max) {
        this.buffer = buffer;
        this.max = max;
    }

    public DatiCondivisi(int num) {
        this.num = num;
        this.syncMax = new Semaphore(0);
        this.syncGen = new Semaphore(1);
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBuffer() {
        return buffer;
    }

    public int getMax() {
        return max;
    }

    public int getNum() {
        return num;
    }
    
    public void waitMax(){
        try {
            this.syncMax.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitGen(){
        try {
            this.syncGen.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void signMax(){
            this.syncMax.release();
    }
    
    public void signGen(){
            this.syncGen.release();
    }
}
