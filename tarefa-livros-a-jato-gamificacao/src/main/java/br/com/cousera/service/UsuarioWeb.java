package br.com.cousera.service;

@Component
@SessionScoped
public class UsuarioWeb {

  private Usuario logado;

  public void login(Usuario usuario) {
    this.logado = usuario;
  }
  
  public String getNome() {
    return logado.getNome();
  }
  
  public boolean isLogado() {
    return logado != null;
  }
}