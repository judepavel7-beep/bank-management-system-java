import java.util.Scanner;

public class Compte{
    Client c;

    public Compte(Client c){
        this.c = c;

    }

    void consulter(){
        System.out.println("Votre solde est:" + c.solde);

    }

    public void depot(){
        Scanner sd = new Scanner(System.in);
        System.out.println("Entrez le montant du depot:");
        int montant = sd.nextInt();

        if (montant > 0) {
            c.solde = c.solde + montant;
            System.out.println("Depot effectuer! Votre nouveau solde est :" + c.solde);
            Fichier.mettreAJour(c);
        }
        else{
            System.out.println("Montant invalide!");

        }

    }

    public void retrait(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le montant!");
        int montt = scanner.nextInt();

        if (montt <= c.solde && montt > 0) {
            c.solde = c.solde - montt;
            System.out.println("Retrait effectuer!");
            System.out.println("Votre nouveau solde est : " + c.solde);
            Fichier.mettreAJour(c);
        }
        else{
            System.out.println("Solde insuffisant");
        }
    }
}