package Model;
import javafx.beans.property.SimpleDoubleProperty;

public class Element{

    private double largeur;
    private double hauteur;
    protected SimpleDoubleProperty x = new SimpleDoubleProperty();
    protected SimpleDoubleProperty y = new SimpleDoubleProperty();

    /**
     * Un element est un objet : un jumper ou un tuyau
     * @param x Position x
     * @param y Position y
     * @param larg Largeur element
     * @param haut Hauteur element
     */
    public Element(double x, double y, int larg, int haut){
        this.x.set(x);
        this.y.set(y);
        this.largeur = larg;
        this.hauteur = haut;
    }

    /**
     * Position x de l'element
     */
    public SimpleDoubleProperty getX(){return this.x;}

    /**
     * Position y de l'element
     */
    public SimpleDoubleProperty getY(){return this.y;}

    public void setY(double y) {this.y.set(y);}

    /**
     * Largeur Element
     */
    public double getLargeur() { return this.largeur;}

    /**
     * Hauteur Element
     */
    public double getHauteur() { return this.hauteur;}

    /**
     * Remettre position x à 0
     */
    public void remisAZero(double valeur){
        this.x.set(valeur);
    }

    /**
     * Faire avancer un élément de 5
     */
    public void avance() {
        this.x.set(this.x.getValue()-5);
    }
}
