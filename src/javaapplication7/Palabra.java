/*
 * Examen 11/11/2016 
 * M015 UF2
 * Marvin Hernandez Lopez
 */
package javaapplication7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marvin Hernandez Lopez
 * @version 1.0
 * @date 11/11/2016
 * @description clase principal que contiene toda la funcionalidad del juego
 */
public class Palabra {
    
    public void ahorcado(){
    
    Scanner lector = new Scanner (System.in);
     
    //array con las pablabras a adivinar.
    String[] paraules={"ATOM","MOLECULA","BIO", "PERL"};
    
   //Variables
    String resposta, llegit="";
    boolean valid;
    int count, encerts, pos;
    char c;
    
    do{
         
           //Genera un numero aleatorio de la cantidad de pablabras que se encuentra en el String paraules.
            Random rnd = new Random();
            int endevina=(int)(rnd.nextDouble()*paraules.length);
            
           //Seleciona la palabra que esta en la pocicion que ha indicado el ramdon.
            String paraula=paraules[endevina];
         
            
            System.out.println("La paraula que has d'encertar té "+paraula.length()+" lletres");

            //Creo l'array de caràcters que mostraran les encertades
            char lletres[]=new char[paraula.length()];
            for(int i=0;i<paraula.length();i++){
                lletres[i] ='_';

            }
            
            //inicia a 0 las variable contador y aciertos.
            count=0;
            encerts=0;
            
            do{
                valid=false;
                
                //COMENTARI VOSTRE
              do{
                       
                System.out.println ("Si us plau, Escriu una lletra valida");
                llegit=lector.nextLine().toUpperCase();
                
                valid=letravalida(llegit);
                
                
              }while(valid == false || llegit.isEmpty() || llegit==null);
              
              //pide una letra, la convierte en mayuscula y la mete en la variable en la pocicion 0
              c=llegit.toUpperCase().charAt(0);
              
              //COMENTARI
              pos = paraula.indexOf(c);
              
              //Comprueba que la introducida está dentro de la palabra que se ha colocado
              if (pos == -1) {
                   count++;
                   System.out.println("Aquesta lletra no es troba dins de la paraula. Ara et queden "+ (10-count)+ " intents");
                   //numero de intento que tiene el jugador
                   if(count == 10) System.out.println("Has esgotat tots els intents");
               } else {
                        
                        //Coloca la palabra acertada en la pocision correcta
                       for(int i=0;i<lletres.length;i++){
                           if(paraula.charAt(i) == c){
                               
                               lletres[i] =c;
                              
                               encerts +=1;
                           }
                           System.out.print(lletres[i]+" ");
                           
                       }
                  System.out.println("Molt bé!!! Torna a intentar-ho");
                  
                  if(encerts == paraula.length()){
                      System.out.println("Has acabat encertant la paraula. Felicitats!!!!");
                      count =10;
                  }

               }

             }while(count !=10);
        
        System.out.println("Vols continuar?(S/N)");
        resposta=lector.nextLine().toUpperCase();
       }while(resposta.equals("S"));
    
    }
    
    
    
    /**
     * @name lletravalida
     * @param llegit 
     * @return boolean true or false
     * @Description debuelve un true cuando la letra cumple con el conjunto de
     * letra colocado en este caso es el abecedario.
     */
    
    private boolean letravalida(String llegit)
    {
        boolean valid=false;
        if(llegit.matches("[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ]"))valid=true;
        return valid;  
    }
    
    
    
    
    
    
    
    
}
