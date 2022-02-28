package util;

public class User {
    private String login,senha;

    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {    return login;   }

    public void setLogin(String login) {   this.login = login;  }

    public String getSenha() {  return senha;   }

    public void setSenha(String senha) {  this.senha = senha;  }
    
    public boolean isValido()
    {   // supondo que a primeira parte é igual a senha
        return login.split("@")[0].equals(senha);
    }    
}