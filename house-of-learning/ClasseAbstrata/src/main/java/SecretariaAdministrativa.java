
public class SecretariaAdministrativa extends Secretaria {

	@Override
	double getBonificacao() {
		return this.getSalario() * 1.15;
	}
}
