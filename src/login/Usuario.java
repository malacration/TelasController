package login;

public class Usuario {
	private String login;
	private String senha;
	
	/*******************************************************************/
	/*Construtor vazio*/
	public Usuario() {}
	
	/*******************************************************************/
	/**Construtor da classe
	 * @param login variavel que guarda o login do usuario
	 * @param senha variavel que guarda a senha do usuario
	 * */
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	/*******************************************************************/
	/*Getters e setters*/
	public String getSenha() {return senha;}	
	public String getLogin() {return login;}
	public void setSenha(String senha) {this.senha = senha;}
	public void setLogin(String login) {this.login = login;}

	public boolean compareTo(Usuario outro) {
		if(this.login.equals(outro.getLogin()))
			if(this.senha.equals(outro.getSenha()))
				return true;
		return false;
	}
	
}
