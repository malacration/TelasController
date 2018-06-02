package core;

import interfaces.Tela;
import login.TelaLogin;
import menuPrincipal.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
			Tela menuPrincipal = new TelaPrincipal();
			TelaLogin window = new TelaLogin(menuPrincipal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
