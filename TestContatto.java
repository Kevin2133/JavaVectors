import java.util.*;

import javax.xml.transform.Source;


public class TestContatto {

    public static int cercaContatto (Vector<Contatto> rubrica, String cognome){
        for(int i = 0; i < rubrica.size(); i++){
            if(rubrica.get(i).cognome.equals(cognome)){
                return i;
            }
        }

        return -1;
    }
    

    public static void main (String args[]){
        int scelta, ind, scelta1;
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
                    System.out.println("Inserire il cognome del contatto da rimuovere");
                    cognome = scanner.nextLine();

                    ind = cercaContatto(rubrica, cognome);

                    if(ind < 0){
                        System.out.println("Nessun contatto trovato");
                    }else{
                        rubrica.remove(ind);
                        System.out.println("Contatto rimosso con successo");
                    }                   
                    
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

                    c = rubrica.get(ind);

                    do{
                        System.out.println("0. esci dal sottomenu");
                        System.out.println("1. Modifica il cognome");
                        System.out.println("2. Modifica il nome");
                        System.out.println("3. Modifica il cellulare");
                        System.out.println("4. Modifica email");
    
                        scelta1 = scanner.nextInt();
                        scanner.nextLine();
    
                        switch(scelta1){
                            case 0:
                                break;
                            case 1:
                                System.out.println("Inserire il nuovo cognome");
                                cognome = scanner.nextLine();

                                c.cognome = cognome;

                                rubrica.set(ind, c);
                                System.out.println("Contatto modificato con successo");
                                break;
                            case 2:
                                System.out.println("Inserisci nuovo nome");
                                nome = scanner.nextLine();

                                c.nome = nome;

                                rubrica.set(ind, c);
                                System.out.println("Contatto modificato con successo");
                                break;
                            case 3:
                                System.out.println("Inserisci nuovo cellulare");
                                cellulare = scanner.nextLine();

                                c.cellulare = cellulare;

                                rubrica.set(ind, c);
                                System.out.println("Contatto modificato con successo");
                                break;
                            case 4:
                                System.out.println("Inserisci nuova email");
                                email = scanner.nextLine();

                                c.email = email;

                                rubrica.set(ind, c);
                                System.out.println("Contatto modificato con successo");
                                break;
                            default:
                                System.out.println("Scelta non prevista");
                                break;
                        }
                    }while(scelta1 != 0);

                    
                    break;
                default:
                    System.out.println("Scelta non prevista");
                    break;
            }
        }while(scelta != 0);

        scanner.close();


    }
}
