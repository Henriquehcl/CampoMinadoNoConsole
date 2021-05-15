import cm.campo.minado.model.Tabuleiro;
import cm.campo.minado.vision.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);//definindo a quantia de linhas, colunas e bombas
		
		new TabuleiroConsole(tabuleiro);
		
		//tabuleiro.abrir(3, 5);//esolhendo o campo para abrir
		//tabuleiro.alternarMarcacao(4, 4);//escolhendo campo para deixar marcado
		
		//System.out.println(tabuleiro);
	}
}
