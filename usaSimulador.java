import java.util.Scanner;

public class usaSimulador {

    public static void menu(Simulador_de_corrida sc){
        
        Scanner scan = new Scanner(System.in);
        int ID = 0, pneu = 0;
        float gasolina = 0;
        char esvaziar_calibrar = ' ';

        int opcao = 0;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("(1) Incluir veículo");
            System.out.println("(2) Remover veículo");
            System.out.println("(3) Abastecer veículo");
            System.out.println("(4) Movimentar um veículo");
            System.out.println("(5) Movimentar todos os veículos");
            System.out.println("(6) Pagar IPVA de um veículo");
            System.out.println("(7) Imprimir todos os dados de um veículo");
            System.out.println("(8) Imprimir todos os dados de todos os veículos");
            System.out.println("(9) Esvaziar/calibrar um pneu específico");
            System.out.println("(10) Esvaziar/calibrar todos os pneus de um veículo específico");
            System.out.println("(11) Imprimir pista de corrida");
            System.out.println("(12) Gravar veículos em arquivo");
            System.out.println("(13) Ler veículos do arquivo");
            System.out.println("(14) Sair da aplicação");
            System.out.println("Opção escolhida: ");
            opcao = scan.nextInt();
            scan.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Insira um ID para o carro(0-19)");
                    ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Carro adicionado");
                    sc.incluir_veiculos(ID);
                    break;
                case 2:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Carro removido");
                    sc.removerVeiculos(ID);
                    break;
                case 3:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Insira a quantidade de gasolina");
                    gasolina = scan.nextFloat();
                    scan.nextLine();
                    sc.abastecer(ID, gasolina);
                    break;
                case 4:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    sc.mover(ID);
                    break;
                case 5:
                    sc.mover();
                    break;
                case 6:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    sc.IPVA(ID);
                    break;
                case 7:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    sc.dadosCarro(ID);
                    break;
                case 8:
                    sc.dadosCarro();
                    break;
                case 9:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Esvaziar(e) ou Calibrar(c)?");
                    esvaziar_calibrar = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println("Qual pneu(1-4)?");
                    pneu = scan.nextInt();
                    scan.nextLine();
                    sc.pneu(ID, esvaziar_calibrar, pneu);
                    break;
                case 10:
                    System.out.println("Insira o ID do carro");
                    ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Esvaziar(e) ou Calibrar(c)?");
                    esvaziar_calibrar = scan.next().charAt(0);
                    scan.nextLine();
                    sc.pneu(ID, esvaziar_calibrar);
                    break;
                case 11:
                    sc.imprimirPista();
                    break;
                case 12:
                    sc.gravarVeiculos();
                    break;
                case 13:
                    sc.lerVeiculos();
                    break;
                case 14:
                    System.out.println("Encerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 14);
    
        scan.close();
    }

    public static void main(String[] args){
        Simulador_de_corrida sc = new Simulador_de_corrida();

        menu(sc);
    }
}
