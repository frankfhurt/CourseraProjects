
public class SecretariaAgencia extends Secretaria {

	@Override
	double getBonificacao() {
		return this.getSalario() * 1.1;
	}

}
