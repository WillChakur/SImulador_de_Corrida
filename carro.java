import java.util.Random;
import java.io.Serializable;

public class carro implements Serializable{
    private roda[] rodas = new roda[4];
    private int id;
    private float combustivel;
    private double valor_venda;
    private boolean ipva;
    private String desenho;
    private int distanciaPercorrida;


    public carro(int id){
        Random r = new Random();
        boolean b;
        int aux;
        
        // Ajustando as rodas
        for(int i = 0; i < 4; i++){
            this.rodas[i] = new roda();
            this.rodas[i].setCalibragem();
        }

        // Ajustando o ID
        this.id = id;

        // Ajustando o IPVA
        b = r.nextBoolean();

        this.ipva = b;
              
        this.combustivel = 0;

        this.desenho = "    _____\n"
        + " __/  |_ \\_\n"
        + "|  _     _``-.\n"
        + "'-(_)---(_)--'";

        // Gerando valor do carro
        aux = r.nextInt(50000 - 10000 + 1) + 10000;

        this.valor_venda = aux;
    }

    public boolean calibragem(){
        for(int i=0; i< 4; i++){
            if(this.rodas[i].getCalibragemPneu() == false){
                return false;
            }
        }
        return true;
    }

    public void mover(){
        if(combustivel >= 5*0.55 && this.ipva == true && calibragem()){
            this.combustivel -= 5*0.55;

            // quantidade deslocada em blocos
            this.distanciaPercorrida += 5;
        }
    }

    public void esvaziarTodos(){
        for(int i=0; i<4; i++){
            this.rodas[i].setCalibragem(false);
        }
    }

    public void pagarIPVA(){
        this.ipva = true;
    }

    public void calibrarTodos(){
        for(int i=0; i<4; i++){
            this.rodas[i].setCalibragem(true);
        }
    }

    public void esvaziarPneu(int num){
        this.rodas[num].setCalibragem(false);
    }

    public void calibrarPneu(int num){
        this.rodas[num].setCalibragem(true);
    }

    public void abastecerCarro(float comb){
        this.combustivel += comb;
    }

    public int getID(){
        return this.id;
    }

    public float getCombustivel(){
        return this.combustivel;
    }

    public double getValor_venda(){
        return this.valor_venda;
    }

    public boolean getIPVA(){
        return this.ipva;
    }

    public int getdistanciaPercorrida(){
        return this.distanciaPercorrida;
    }

    public String toString(){
        return ("Id: " + this.getID() + "\n" + "IPVA: " + this.getIPVA() + "\n"
        + "Valor de Venda: " + this.getValor_venda() + "\n" + "Gasolina: "
        + this.combustivel + "\n" + "Calibrado: " + this.calibragem() + "\n"
        + this.desenho);
    }

    public String getDesenho(){
        return this.desenho;
    }
}

