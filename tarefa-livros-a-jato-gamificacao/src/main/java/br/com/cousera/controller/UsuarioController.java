package br.com.cousera.controller;

import javax.annotation.Resource;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.cousera.service.UsuarioWeb;

@Resource
public class UsuarioController {

	private final UsuarioWeb usuarioWeb;
	private final Validator validator;

	// ...
	public UsuarioController(UsuarioDao dao, Result result, Validator validator, UsuarioWeb usuarioWeb) {
    //...
    this.usuarioWeb = usuarioWeb;
    this.validator = validator;
  }

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		validator.onErrorUsePageOf(UsuarioController.class).loginForm();

		usuarioWeb.login(carregado);

		// result.redirectTo(ProdutosController.class).lista();
	}
}