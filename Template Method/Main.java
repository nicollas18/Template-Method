import java.util.Scanner;

// Classe abstrata representando o template para pedidos de comida
abstract class PedidoDeComida {

    protected String restaurante;
    protected String sabor;


    // Template Method
    public final void fazerPedido() {
        escolherRestaurante();
        selecionarItensDoCardapio();
        efetuarPagamento();
        fimPedido();
    }

    // Métodos abstratos a serem implementados pelas subclasses
    abstract void escolherRestaurante();

    abstract void selecionarItensDoCardapio();

    abstract void efetuarPagamento();

    abstract void fimPedido();
 
}

// Subclasse para pedido de pizza
class PedidoPizza extends PedidoDeComida {

    Scanner scan = new Scanner(System.in);
    int input;

    @Override
    void escolherRestaurante() {
        System.out.println("\nEscolha uma pizzaria");
        System.out.println("1 - Bella Pizza");
        System.out.println("2 - Pizzaria da Nonna");
        System.out.println("3 - Pizaa Express");

        input = scan.nextInt();

        if (input == 1) {
            restaurante = "Bella Pizza";
        }
        else if (input == 2) {
            restaurante = "Pizzaria da Nonna";
        }
        else if (input == 3){
            restaurante = "Pizaa Express";
        }

        else {
            System.out.println("Opção Inválida");
            return;
        }

        //System.out.println(pizzaria);
    }

    @Override
    void selecionarItensDoCardapio() {
        System.out.println("\nEscolha os sabores de pizza");
        System.out.println("1 - Margherita");
        System.out.println("2 - Pepperoni Especial");
        System.out.println("3 - Quatro Queijos");
        System.out.println("4 - Vegetariana");

        input = scan.nextInt();

        if (input == 1){
            sabor = "Margherita";
        } else if (input == 2){
            sabor = "Pepperoni Especial";
        } else if (input == 3) {
            sabor = "Quatro Queijos";
        } else if (input == 4) {
            sabor = "Vegetariana";
        } else {
            System.out.println("Opção Inválida");
        }

        //System.out.println(sabor);
    }

    @Override
    void efetuarPagamento() {
        System.out.println("\nEfetuando pagamento via pix");
    }

    @Override
    void fimPedido() {
        System.out.println("Voce pediu no " + restaurante + " uma pizza de sabor " + sabor);  
    }
}

// Subclasse para pedido de sushi
class PedidoSushi extends PedidoDeComida {

    Scanner scan = new Scanner(System.in);
    int input;

    @Override
    void escolherRestaurante() {
        System.out.println("\nEscolha um restaurante");
        System.out.println("1 - Sushi Mori");
        System.out.println("2 - Sakura Sushi");
        System.out.println("3 - Sushimania");

        input = scan.nextInt();

        if (input == 1) {
            restaurante = "Sushi Mori";
        } else if (input == 2) {
            restaurante = "Sakura Sushi";
        } else if (input == 3) {
            restaurante = "Sushimania";
        } else {
            System.out.println("Opção Inválida");
        }
    }

    @Override
    void selecionarItensDoCardapio() {
        System.out.println("\nEscolha os tipos de sushi");
        System.out.println("1 - Sashimi Misto");
        System.out.println("2 - Uramaki Filadélfia");
        System.out.println("3 - Temaki de Camarão");
        System.out.println("4 - Sushi Veggie");

        input = scan.nextInt();

        if (input == 1) {
            sabor = "Sashimi Misto";
        } else if (input == 2) {
            sabor = "Uramaki Filadélfia";
        } else if (input == 3) {
            sabor = "Temaki de Camarão";
        } else if (input == 4) {
            sabor = "Sushi Veggie";
        } else {
            System.out.println("Opção Inválida");
        }
    }

    @Override
    void efetuarPagamento() {
        System.out.println("\nEfetuando pagamento via cartão");
    }

    @Override
    void fimPedido() {
        
        System.out.println("Você pediu no " + restaurante + " um " + sabor);
        System.out.println("Arigato, hinpan ni modotte kite ne.\n");
        
    }

}

// Classe principal para testar o padrão Template Method
public class Main {
    public static void main(String[] args) {

        System.out.println("Pedido de Pizza:");
        PedidoDeComida pedidoPizza = new PedidoPizza();
        pedidoPizza.fazerPedido();

        System.out.println("\nPedido de Sushi:");
        PedidoDeComida pedidoSushi = new PedidoSushi();
        pedidoSushi.fazerPedido();
    }
}
