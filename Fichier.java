import java.io.*;

public class Fichier {
    public static void sauvegarder(Client c) {
        try {

            FileWriter fw = new FileWriter("cliinfo.txt", true);

            fw.write(c.nom + ";" + c.mdp + ";" + c.solde + "\n");

            fw.close();

        } catch (IOException e) {
            System.out.println("Fichier non sauvegarder!");
        }
    }

public static boolean verifier(String nom, String mdp) {

    try {

        FileReader fr = new FileReader("cliinfo.txt");
        BufferedReader br = new BufferedReader(fr);

        String ligne = br.readLine();

        while (ligne != null) {

            String[] info = ligne.split(";");

            String nomFichier = info[0];
            String mdpFichier = info[1];

            if (nom.equals(nomFichier) && mdp.equals(mdpFichier)) {
                br.close();
                return true;
            }

            ligne = br.readLine();
        }

        br.close();

    } catch (IOException e) {
        System.out.println("Erreur lecture fichier");
    }

    return false;
}

public static void mettreAJour(Client c){

    try{

        FileWriter fw = new FileWriter("cliinfo.txt", true);
        fw.write(c.nom + ";" + c.mdp + ";" + c.solde + "\n");
        fw.close();

    }
    catch(IOException e){
        System.out.println("Erreur mise a jour");
    }

}
}