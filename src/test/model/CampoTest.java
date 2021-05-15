package test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cm.campo.minado.exception.ExplosaoException;
import cm.campo.minado.model.Campo;

public class CampoTest {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void vizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}

	@Test
	void vizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}

	@Test
	void vizinhoRealDistancia1Emcima() {
		Campo vizinho = new Campo(2, 3);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}

	@Test
	void vizinhoRealDistancia1Embaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}

	@Test
	void vizinhoRealDistanciaDiagonal() {
		Campo vizinho = new Campo(2, 2);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}

	@Test
	void naoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean result = campo.adicionarVizinho(vizinho);
		assertFalse(result);
	}

	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAbriNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.minar();
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	@Test
	void testeAbrirComvizinhos1() {
		Campo campo22 = new Campo(2, 2);
		Campo campo11 = new Campo(1,1);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	@Test
	void testeAbrirComvizinhos2() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}

}
