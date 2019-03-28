/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Francesco
 */
public class PreVerifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            int num;
            System.out.println("Inserisci quanti numeri vuoi che vengano generati");
            num = input.nextInt();
            DatiCondivisi ptrDati = new DatiCondivisi(num);
            ThGenera gen = new ThGenera(ptrDati);
            ThMassimo max = new ThMassimo(ptrDati);
            
            gen.start();
            max.start();
            
            gen.join();
            max.join();
            
            System.out.println("Numero massimo = " + ptrDati.getMax());
        } catch (InterruptedException ex) {
            Logger.getLogger(PreVerifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
  
