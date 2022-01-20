package Model;

public class Joueur{

    public String pseudo;
    public int highScore;

    /**
     * Un joueur est une personne qui n'a pas d'identifiant, à chaque lancement de jeu, un nouveau joueur
     * Le highScore d'un joueur est le meilleur score qu'un joueur a obtenu sur plusieurs parties (après avoir relancer une partie)
     * @param nom Nom passé en paramètre et récupéré dans la vue Accueil.fxml
     */
    public Joueur(String nom){
        this.pseudo=nom;
        this.highScore=0;
    }

    /**
     * Retourne le Pseudo d'un joueur
     */
    public String getPseudo(){return pseudo;}

    /***
     * Retourne le meilleur score d'un joueur
     */
    public int getHighScore(){return highScore;}

    /**
     * Permet de définir le meilleur score d'un joueur
     */
    public void setHighScore(int score){
        if(highScore < score){
            this.highScore = score;
        }else;
    }
}