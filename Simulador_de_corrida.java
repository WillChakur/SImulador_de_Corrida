import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream ;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream ;


public class Simulador_de_corrida {
    private carro[] carros = new carro[20];
    static int qtideVeiculos=0;
    Scanner scan = new Scanner(System.in);
    Random r = new Random();

    public void incluir_veiculos(int id){

         if(id >=0 && id < 20){
            if(carros[id] == null){
                qtideVeiculos += 1;
                carros[id] = new carro(id);
            }
            else{
                System.out.println("Já existe um carro com esse ID");
            }
        }
        else{
            System.out.println("ID inválido");
        }

       
        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine();
       
    }

    public void removerVeiculos(int id){

        if(carros[id] != null){
            carros[id] = null;
            qtideVeiculos -= 1;
        }
        else{
            System.out.println("Carro inexistente");
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void mover(int id){
        if(carros[id] != null){
            carros[id].mover();
        }
        else{
            System.out.println("Carro inexistente");
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void mover(){
        for (int i = 0; i < 20; i++) {
            if(carros[i] != null){
                carros[i].mover();
            }
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void abastecer(int id, float comb){

        if(carros[id] != null){
            carros[id].abastecerCarro(comb);
        }
        else{
            System.out.println("Carro inexistente");
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void dadosCarro(){
        for (int i = 0; i < 20; i++) {
            if(carros[i]!= null){
                System.out.println(carros[i].toString());    
            }
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void dadosCarro(int id){

        if(carros[id] != null){
            System.out.println(carros[id].toString());
        }
        else{
            System.out.println("Carro inexistente");
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void pneu(int id, char esva_calib, int num_pneu){


        if(carros[id] != null){
            if(num_pneu >= 0 && num_pneu <= 4){
                if(esva_calib == 'c'){
                    carros[id].calibrarPneu(num_pneu);
                }
                else if(esva_calib == 'e'){
                    carros[id].esvaziarPneu(num_pneu);
                }
                else{
                    System.out.println("Opção inválida");
                }
            }
            else{
                System.out.println("Pneu inválido");
            }
        }
        else{
            System.out.println("Carro inexistente");
        }    

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void pneu(int id, char esva_calib){
        if(carros[id] != null){
            if(esva_calib == 'c'){
                carros[id].calibrarTodos();
            }
            else if(esva_calib == 'e'){
                carros[id].esvaziarTodos();
            }
        }
        else{
            System.out.println("Carro inexistente");
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void imprimirPista(){
        String spaces = "";

        for (int i = 0; i < 20; i++) {
            if(carros[i] != null){
                for(int j = 0; j < carros[i].getdistanciaPercorrida(); j++){
                    spaces += " ";
                }

                System.out.print(spaces+"    ____\n");
                System.out.print(spaces+" __/  |_ \\_\n");
                System.out.print(spaces+"|  _     _``-.\n");
                System.out.print(spaces+"'-(_)---(_)--'\n\n\n");

                spaces = "";
            }
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void IPVA(int ID){
        if(carros[ID] != null){
            carros[ID].pagarIPVA();
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }


    public void gravarVeiculos(){
        File arquivo = new File("veiculos.dat");

        try{
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(carros);

            oos.flush();
            oos.close();
            fout.close();

        }catch(Exception ex){
            System.err.println("erro: " + ex.toString());
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }

    public void lerVeiculos(){
        File arquivo = new File("veiculos.dat");

        try{
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            carro[] veiculos = (carro[]) oin.readObject();

            oin.close();
            fin.close();

            this.carros = veiculos;

        }catch(Exception ex){
            System.err.println("erro: " + ex.toString());
        }

        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine(); 
    }
}
