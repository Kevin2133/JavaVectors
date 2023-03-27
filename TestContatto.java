import java.rmi.Remote;
import java.util.*;

import javax.sound.sampled.SourceDataLine;



public class TestContatto {
    

    public static void main (String args[]){
        int scelta, ind, scelta2;
        Scanner scanner = new Scanner(System.in);
        Vector<Contatto> rubrica = new Vector<Contatto>();
        String nome, cognome, cellulare, email;
        Contatto c;

        do{
            System.out.println("0. esci");
            System.out.println("1. Inserisci un contatto in rubrica");
            System.out.println("2. Visualizza la rubrica");
            System.out.println("3. Rimuovi contatto dalla rubrica");
            System.out.println("4. Modifica un contatto in rubrica");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 0:
                    break;
                case 1:
                    System.out.println("Inserire il nome");
                    nome = scanner.nextLine();

                    System.out.println("Inserire cognome");
                    cognome = scanner.nextLine();

                    System.out.println("Inserire cellulare");
                    cellulare = scanner.nextLine();

                    System.out.println("Inserire Email");
                    email = scanner.nextLine();

                    c = new Contatto(nome, cognome, cellulare, email);
                    rubrica.add(c);

                    System.out.println("contatto aggiunto con successo");
                    break;
                case 2:
                    if(rubrica.size() == 0){
                        System.out.println("La rubrica e' vuota");
                    }

                    for(int i = 0; i < rubrica.size(); i++){
                        System.out.println("Nome: " + rubrica.get(i).nome);
                        System.out.println("Cognome: " + rubrica.get(i).cognome);
                        System.out.println("Cellulare: " + rubrica.get(i).cellulare);
                        System.out.println("Email: " + rubrica.get(i).email);
                        System.out.println("******************");
                    }
                    break;
                case 3:
                    do{
                        System.out.println("Inserire un indice da rimuovere");
                        ind = scanner.nextInt();
                        scanner.nextLine();

                        if((ind < 0) || (ind > rubrica.size() - 1)){
                            System.out.println("Indice non valido");
                        }
                    }while((ind < 0) || (ind > rubrica.size() - 1));
                    
                    rubrica.remove(ind);
                    System.out.println("Contatto rimosso con successo");
                    break;
                case 4:
                    do{
                        System.out.println("Inserire un indice da modificare");
                        ind = scanner.nextInt();
                        scanner.nextLine();

                        if((ind < 0) || (ind > rubrica.size() - 1)){
                            System.out.println("Indice non valido");
                        }
                    }while((ind < 0) || (ind > rubrica.size() - 1));
                    break;
                default:
                    System.out.println("Scelta non prevista");
                    break;
            }
        }while(scelta != 0);

        scanner.close();


    }
}
