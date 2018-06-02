package login;


import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import interfaces.Tela;

public class TelaLogin extends JFrame {
	

	private JPasswordField txtSenha;
	
	private Tela telaAposOLogin;
	
	public TelaLogin(Tela telaAposOLogin) {
		this.telaAposOLogin = telaAposOLogin;
		this.setBounds(100, 100, 203, 235);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		TextField txtLogin = new TextField();
		txtLogin.setBounds(10, 41, 167, 22);
		this.getContentPane().add(txtLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 21, 46, 14);
		this.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 69, 46, 14);
		this.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 94, 167, 22);
		this.getContentPane().add(txtSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				Usuario teste = new Usuario(txtLogin.getText().toLowerCase(),txtSenha.getText().toLowerCase());
				if(logar(teste)) {
					setVisible(false);
				}
				else {
					System.out.println("2");
				}
			}
		});
		btnLogin.setBounds(10, 137, 167, 48);
		this.getContentPane().add(btnLogin);
		this.setVisible(true);
	}
	
	@SuppressWarnings("resource")
	public boolean logar(Usuario user) {
		Usuario sucesso = new Usuario();
		try {
			
			FileReader arq = new FileReader("usuarios.txt");
			BufferedReader leitor = new BufferedReader(arq);
			String usuario = "";
			String senha = ""; 
			
			while(usuario != null) {
				usuario = leitor.readLine();
				senha = leitor.readLine();
				if(user.getLogin().equals(usuario)) {
					if(user.getSenha().equals(senha)){
						sucesso.setLogin(usuario);
						sucesso.setSenha(senha);
						arq.close();
						telaAposOLogin.ativa();
						return true;
					}
				}
			}
			
			arq.close();
			
		}catch(IOException e1){
			e1.printStackTrace();
			System.out.println("Erro na leitura do arquivo:" + e1.getMessage() + ".");		
			FileWriter escritor;
			
			try {
				
				escritor = new FileWriter("usuarios.txt");
				PrintWriter cout = new PrintWriter(escritor);
				cout.println("admin");
				cout.print("123");
				escritor.close();
				System.out.println("Um novo arquivo foi criado.");
				
			} catch (IOException e2) {
				
				e2.printStackTrace();
				
			}
			
		}
		System.out.println("ruim");
		return false;
	}
}
