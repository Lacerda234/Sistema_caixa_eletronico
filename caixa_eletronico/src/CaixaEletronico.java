import java.util.Scanner;
        
public class CaixaEletronico {
    private double saldoTotal = 100;
    Scanner entrada = new Scanner(System.in);
    
    public int userConta(){
        System.out.println("Informe o numero da sua conta: ");
        int conta;
        conta = entrada.nextInt();
        return conta;
    }
    
    public int userPin(){
        System.out.println("Informe seu numero PIN: ");
        int pin;
        pin = entrada.nextInt();
        return pin;
    }
    
    public void iniciarCaixa(){
        userConta();
        userPin();
        menuPrincipal();
    }
    
    public void menuPrincipal(){
        int escolha;
        System.out.println("\nMENU PRINCIPAL CAIXA:");
        System.out.println("1 - Ver saldo da conta");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Encerrar transação");
        System.out.println("ESCOLHA UMA DAS OPÇÕES: ");
        escolha = entrada.nextInt();
        switch(escolha){
            case 1:
                visualizarSaldo();
                break;
            case 2:
                sacar();
                break;
            case 3:
                adicionarDinheiro();
                break;
            case 4:
                System.out.println("Obrigado por usar esse caixa eletrônico!");
        }
    }
    
    public void visualizarSaldo(){
        System.out.println("Informações da conta: ");
        System.out.println("\t--Saldo Total: $"+saldoTotal);
        menuPrincipal();
    }
    
    public void depositar(int quantidadeDeposito){
        System.out.println("\n ***Por favor insira seu dinheiro agora...***");
        saldoTotal = saldoTotal+quantidadeDeposito;
    }
    
    public void verificarFundos(int totalRetirar){
        if(saldoTotal - totalRetirar < 0){
            System.out.println("\n ***ERROR!!! Saldo insuficiente na sua conta***");
        }else{
            saldoTotal = saldoTotal - totalRetirar;
            
            System.out.println("\n ***Por favor pegue seu dinheiro agora...***");
        }
    }
    
    public void adicionarDinheiro(){
        int addSelecao;
        
        System.out.println("OPÇÕES DE DEPOSITOS: ");
        System.out.println("1 - $20");
        System.out.println("2 - $40");
        System.out.println("3 - %60");
        System.out.println("4 - %100");
        System.out.println("5 - Retornar para o menu");
        System.out.println("ESCOLHA UMA DAS OPÇÕES: ");
        addSelecao = entrada.nextInt();
        switch(addSelecao){
            case 1:
                depositar(20);
                menuPrincipal();
                break;
            case 2:
                depositar(40);
                menuPrincipal();
                break;
            case 3:
                depositar(60);
                menuPrincipal();
                break;
            case 4:
                depositar(100);
                menuPrincipal();
                break;
            case 5:
                menuPrincipal();
                break;
        }
    }
    
    public void sacar(){
        int escolhaSaque;
        
        System.out.println("OPÇÕES DE SAQUE: ");
        System.out.println("1 - $20");
        System.out.println("2 - $40");
        System.out.println("3 - $60");
        System.out.println("4 - $100");
        System.out.println("5 - Retornar para o menu");
        System.out.println("ESCOLHA UMA DAS OPÇÕES: ");
        escolhaSaque = entrada.nextInt();
        switch(escolhaSaque){
            case 1:
                verificarFundos(20);
                menuPrincipal();
                break;
            case 2:
                verificarFundos(40);
                menuPrincipal();
                break;
            case 3:
                verificarFundos(60);
                menuPrincipal();
                break;
            case 4:
                verificarFundos(100);
                menuPrincipal();
                break;
            case 5:
                menuPrincipal();
                break;
        }
    }
    
    public static void main(String[] args) {
        CaixaEletronico meuCaixaEletronico = new CaixaEletronico();
        meuCaixaEletronico.iniciarCaixa();
    }
}
