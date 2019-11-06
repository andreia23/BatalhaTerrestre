///// O MEU ////////////////////////////////////////////

import java.util.Random;

public class JogoBatalhaTerrestre {
	private int[][] matriz= new int[10][10];
	private int[][] matriz_publica = new int[10][10];
	private int quant_tiros = 0;
	private int acertos = 0;
	private int tentativas = 0;

	///Construtor

	public JogoBatalhaTerrestre() {
		super();


		//Inicializando a matriz interna
		for(int i = 0; i<10; i++)
			for(int j = 0; j<10; j++) {
				this.matriz[i][j] = 0;
			}
		//Inicializando a matriz publica
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				matriz_publica[x][y] = 0;
			}
		}

		//Sorteando/ as 5 posições
		Random random = new Random();
		int cont_random = 0;
		while(cont_random < 5) {
			int x = random.nextInt(10);
			int y = random.nextInt(10);
			if(this.matriz[x][y] == 0){
				this.matriz[x][y] = 1;
				cont_random++;
			}
		}

	}

	/////Falta consertar
	public boolean  Verifica_proximidade(int lin, int col){
		Boolean status = false;	
		//LINHA SENDO 0
		if(lin == 0 ) {
			//1 estando encima
			if(matriz[(lin+1)][col] == 1 ) {
				status = true;
			}
			//Coluna sendo 0
			else if(col == 0) {
				col = 1;
				//1 do LADO direito
				if(matriz[(lin)][(col-1)+1] == 1 ) {
					status = true;}
				//Canto superior esquerdo
				if(matriz[lin+1][(col-1)+1] == 1 )
					status = true;
			}
			//Coluna sendo 9
			else if(col == 9) {
				col = 8;
				//1 do LADO ESQUERDO
				if(matriz[(lin)][(col+1)-1] == 1 ) {
					status = true;}
				//Canto superior direito
				if(matriz[lin+1][col+1] == 1 ) {
					status = true;}
			}

			else {
				//LADO DIREITO
				if(matriz[(lin)][col-1] == 1 ) {
					status = true;}
				//LADO ESQUERDO
				if(matriz[(lin)][col+1] == 1 ) {
					status = true;}

				//Canto superior esquerdo
				if(matriz[lin+1][col-1] == 1 )
					status = true;
				//Canto superior direito
				if(matriz[lin+1][col+1] == 1 )
					status = true;
			}

		}
		///LINHA SENDO 9	
		else if (lin == 9 ) {
			//1 estando em baixo
			if(matriz[(lin-1)][col] == 1 ) {
				status = true;
			}
			//Coluna sendo 0
			else if(col == 0) {
				col = 1;
				//LADO DIREITO
				if(matriz[(lin)][(col-1) + 1] == 1 ) {
					status = true;}
				//Canto superior esquerdo
				if(matriz[lin-1][(col-1)+1] == 1 ) {
					status = true;}
			}

			//Coluna sendo 9
			else if(col == 9) {
				col = 8;
				//LADO ESQUERDO
				if(matriz[(lin)][col+1] == 1 ) {
					status = true;}

				//Canto superior direito
				if(matriz[lin-1][(col+1)-1] == 1 ) {
					status = true;}
			}
			else {
				//LADO DIREITO
				if(matriz[(lin)][col-1] == 1 ) {
					status = true;}
				//LADO ESQUERDO
				if(matriz[(lin)][col+1] == 1 ) {
					status = true;}
				//Canto superior esquerdo
				if(matriz[lin-1][col-1] == 1 ) {
					status = true;}

				//Canto superior direito
				if(matriz[lin-1][col+1] == 1 ) {
					status = true;}
			}

		}
		else if(col == 0) {	
			//1 estando em baixo
			if(matriz[(lin + 1)][col] == 1 ) {
				status = true;}

			else if(matriz[(lin - 1)][col] == 1 ) {
				status = true;}

			//Linha sendo 9
			else if(lin == 9) {
				col = 1;
				//LADO ESQUERDO
				if(matriz[(lin)][(col-1)+1] == 1 ) {
					status = true;}

				//Canto superior direito
				if(matriz[lin-1][col-1] == 1 ) {
					status = true;}
			}
			else {
				//1 estando no LADO DIREITO
				if(matriz[(lin - 1)][col+1] == 1 ) {
					status = true;}

				//Canto superior esquerdo
				if(matriz[lin+1][col+1] == 1 )
					status = true;

				//LADO ESQUERDO
				if(matriz[(lin)][col+1] == 1 ) {
					status = true;}

				//Canto superior direito
				if(matriz[lin-1][col+1] == 1 ) {
					status = true;}
			}

		}
		//Coluna sendo 9
		else if(col == 9) {	
			//1 estando em baixo
			if(matriz[(lin - 1)][col] == 1 ) {
				status = true;}

			else if(matriz[(lin + 1)][col] == 1 ) {
				status = true;}
			//Linha sendo 0
			else if (lin == 0) {
				lin = 1;
				//1 estando no LADO DIREITO
				if(matriz[(lin)][col-1] == 1 ) {
					status = true;}
				//Canto superior esquerdo
				if(matriz[lin+1][col-1] == 1 )
					status = true;
			}

			else {
				//1 estando no LADO DIREITO
				if(matriz[(lin)][col-1] == 1 ) {
					status = true;}
				//Canto superior esquerdo
				if(matriz[lin+1][col-1] == 1 )
					status = true;

				//Canto superior esquerdo
				if(matriz[lin+1][col-1] == 1 )
					status = true;


			}

		}

		else  {
			//Em cima
			if(matriz[lin+1][col] == 1 ) {
				status = true;
			}
			//Canto superior esquerdo
			if(matriz[lin+1][col+1] == 1 )
				status = true;
			//Canto superior direito
			if(matriz[lin+1][col-1] == 1 )
				status = true;

			//Canto inferior esquerdo
			if(matriz[lin-1][col+1] == 1 )
				status = true;
			//Canto inferior direito
			if(matriz[lin-1][col-1] == 1 )
				status = true;
			//Lado esquerdo
			if(matriz[lin][col-1] == 1 )
				status = true;
			//Lado direito
			if(matriz[lin][col+1] == 1 )
				status = true;
			//Em baixo
			if(matriz[lin-1][col] == 1 )
				status = true;
		}

		return status;
	}




	/// STRING ATIRAR

	public String atirar(int linha, int coluna) throws Exception {

		if(this.matriz_publica[linha][coluna] != 0 )
			throw new Exception("Tente outro");

		else {
			if(matriz[linha][coluna] == 1 ) {

				this.quant_tiros += 1;
				this.acertos +=1;
				this.tentativas += 1;
				this.matriz_publica[linha][coluna] = 1;
				return "Alvo";

			}
			else if (Verifica_proximidade(linha,coluna) == true) {

				this.quant_tiros += 1;
				this.tentativas += 1;
				this.matriz[linha][coluna] = 2;
				this.matriz_publica[linha][coluna] = 2;
				return "Proximo";
			}

			else {
				this.quant_tiros += 1;
				this.tentativas += 1;
				this.matriz[linha][coluna] = 3;
				this.matriz_publica[linha][coluna] = 3;
				return "Distante";
			}
		}
	} 

	///// VERIFICANDO SE O JOGO ACABOU
	public boolean terminou() {
		if(tentativas >0) {
			if(acertos == 5)
				return true;
			else
				if(tentativas==20)
					return true;
				else
					return false;
		}
		else{
			return false;
		}	
	}

	/// RESULTADO FINAL

	public String getResultadoFinal() {
		if(terminou()) {
			if(acertos == 5) {
				return "Voce ganhou com " + tentativas + " tentativa(s)";
			}	
			else{
				return "Voce perdeu, esgotarem-se os 20 tiros !!";
			}	
		}
		else{
			return "jogo ainda em execucao";
		}
	}


	/// Getters e setters

	public int getQuant_tiros() {
		return quant_tiros;
	}

	public void setQuant_tiros(int quant_tiros) {
		this.quant_tiros = quant_tiros;
	}

	public int get_acertos() {
		return acertos;
	}

	public void set_acertos(int quant_acertos) {
		this.acertos = acertos;
	}

	/// MÉTODO STRING

	@Override
	public String toString() {
		String matriz_string = "\nLegenda:\n1 - Tiro no alvo\n2 - Tiro proximo do alvo\n3 - Tiro longe\n\n";
		matriz_string  +="\n    0  1  2  3  4  5  6  7  8  9 \n";

		///matriz_publica
		for(int x = 0; x < 10; x++) {
			if(x == 9) matriz_string+=String.format(" %d- ", x);
			else matriz_string+=String.format(" %d- ",x);

			for(int y = 0; y < 10; y++) {

				matriz_string+=matriz_publica[x][y] + "  ";

			}
			matriz_string+="\n";

		}

		//Matriz interna 
		matriz_string+="\n    0  1  2  3  4  5  6  7  8  9 \n";
		for(int x = 0; x < 10; x++) {
			if(x == 9) matriz_string+=String.format(" %d- ", x);
			else matriz_string+=String.format(" %d- ",x);

			for(int y = 0; y < 10; y++) {
				matriz_string+=matriz[x][y] + "  ";
			}
			matriz_string+="\n";

		}	
		//Retorno do ToString
		return matriz_string;
	}


}













