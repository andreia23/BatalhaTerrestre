import java.util.Scanner;
 
 
 public class AplicacaoConsole {
    public static void main(String[] args) {
 
        JogoBatalhaTerrestre jogo = new JogoBatalhaTerrestre();
        System.out.println(jogo);
 
        
        Scanner teclado = new Scanner(System.in);
        int linha, coluna;
        

        do{
            System.out.print("Digite a linha do tiro:");
            linha = teclado.nextInt();
            System.out.print("Digite a coluna do tiro: ");
            coluna = teclado.nextInt();
            try {
                String resposta = jogo.atirar(linha,coluna);
                System.out.println(resposta);
            }catch(Exception erro) {
				System.out.println(erro.getMessage());
				continue;
			}
            System.out.println("total de acertos:"+jogo.get_acertos());
            System.out.println("total de tiros:"+jogo.getQuant_tiros());
            System.out.println(jogo);
 
        }while(!jogo.terminou());
 
        System.out.println("\n GAME OVER !!");
        System.out.println(jogo.getResultadoFinal());
        System.out.println(jogo.toString());
    }
 
}