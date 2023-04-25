import java.util.Random;
import java.io.Serializable;

public class roda implements Serializable{
    private boolean calibragemPneu;

    public void setCalibragem(){
        Random r = new Random();
        boolean aux;
        aux = r.nextBoolean();
        this.calibragemPneu = aux;
    }

    public void setCalibragem(boolean b){
        this.calibragemPneu = b;
    }

    public boolean getCalibragemPneu(){
        return this.calibragemPneu;
    }
}
