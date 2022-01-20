package Model;

import static Launch.Constant.GRAVITY;

public class Jumper extends Element{


    private double velocityY = 0;

    private boolean EntrainDeSauter;
    private boolean hauteurMax = false;
    private boolean hauteurMin = false;

    /**
     * Constructeur de notre classe Jumper
     * @param x Position en abscisse
     * @param y Position en ordonnee
     */
    public Jumper(double x, double y){
        super(x, y, 28, 50);
        this.EntrainDeSauter =false;
    }

    /**
     * True si jumper est en train de sauter sinon false
     */
    public boolean isEntrainDeSauter() {
        return EntrainDeSauter;
    }

    /**
     * True si hauteur max atteint
     */
    public boolean isHauteurMax() {
        return hauteurMax;
    }

    /**
     * On définit l'hauteur max de saut
     */
    public void setHauteurMax(boolean hauteurMax) {
        this.hauteurMax = hauteurMax;
    }

    /**
     * True si hauteur min atteint
     */
    public boolean isHauteurMin() {
        return hauteurMin;
    }

    /**
     * On définit l'hauteur min de saut
     */
    public void setHauteurMin(boolean hauteurMin) {
        this.hauteurMin = hauteurMin;
    }

    /**
     * Savoir si jumper est en train de sauter ou non
     * @param entrainDeSauter Boolean true si jumper est en train de sauter
     */
    public void setEntrainDeSauter(boolean entrainDeSauter) {
        this.EntrainDeSauter = entrainDeSauter;
    }

    /**
     *
     * @param t Un Element, ici un tuyau pour savoir si contact avec jumper
     * @return true si contact sinon false
     */
    public boolean contactTuyau(Tuyau t){
        if(this.getX().floatValue() + this.getLargeur() < t.getX().floatValue() || this.getX().floatValue() + this.getLargeur() > t.getX().floatValue() + 21.50 ||
                this.getY().floatValue() + this.getHauteur() <= t.getY().floatValue() || this.getY().floatValue() >= t.getY().floatValue() + t.getHauteur())
        {
            return false;
        }
        else return true;
    }

    /**
     * Calcul des coordonnées de Jumper (avec gravité et vélocité)
     */
    public void calculCoordonnee(){
        if(isEntrainDeSauter()) {
            if (y.floatValue() > 160 && !isHauteurMax()) {
                setHauteurMin(false);
                y.set(y.floatValue() + velocityY - GRAVITY);
                if(y.floatValue() <= 160) {
                    y.set(160);
                    setHauteurMax(true);
                    velocityY = 0;
                }
            }

            if(this.getY().floatValue() < 245 && isHauteurMax() && !isHauteurMin()){
                y.set(y.floatValue() + velocityY + GRAVITY);
                if(y.floatValue() >= 245)
                {
                    y.set(245);
                    setHauteurMin(true);
                    setHauteurMax(false);
                    setEntrainDeSauter(false);
                }
            }
        }
    }

    public void sautDebut() {
        if(!isEntrainDeSauter()) {
            setEntrainDeSauter(true);
            velocityY = -6;
        }
    }
}