import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Client c = null;

        int choix;
        do{
        System.out.println("1- Inscription");
        System.out.println("2- Connexion");
        System.out.println("3- Quitter");

        choix = sc.nextInt();
        sc.nextLine();

        switch (choix) {
            case 1:
                System.out.println("Entrez votre nom:");
                String nom = sc.nextLine();
                System.out.println("Entrez votre mot de passe:");
                String mdp = sc.nextLine();

                c = new Client(nom, mdp, 0);

                Fichier.sauvegarder(c);

                System.out.println("Inscription reussi.");
                break;

            case 2:
                System.out.println("Entrez votre nom:");
                String name = sc.nextLine();
                System.out.println("Entrez votre mot de passe:");
                String mp = sc.nextLine();


                if (Fichier.verifier(name, mp)) {
                    c = new Client(name, mp, 0); 
                    Compte cp = new Compte(c);
                    int num;
                    do{
                    System.out.println("Connexion reussie.");
                    System.out.println("1- Consulter son solde.");
                    System.out.println("2- Faire un depot.");
                    System.out.println("3- Faire un retrait.");
                    System.out.println("4- Quitter");

                        num = sc.nextInt();
                        sc.nextLine();

                    if (num == 1) {
                        cp.consulter();
                    }
                    else if (num == 2) {
                        cp.depot();
                    }
                    else if(num == 3) {
                        cp.retrait();
                        
                    }

                    }
                    while (num != 4);

                }
                else{
                    System.out.println("Coordonnee incorrect");
                }

                break;
            case 3:
                System.out.println("Au revoir");    

            default:
                System.out.println("Erreur!");
                break;
        }
        }while(choix != 3);

    }

}