import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	@OneToMany
	@JoinColumn(name = "pessoa_id")
	private List<Cachorro> cachorros;

	public Pessoa() {}

	public Pessoa(String nome) {
		this.nome = nome;
		this.cachorros = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cachorro> getCachorros() {
		return cachorros;
	}

	public void adicionaCachorros(Cachorro... cachorros) {
		for (Cachorro cachorro : cachorros) {
			this.cachorros.add(cachorro);
		}
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id= " + id + ", nome= " + nome + ", cachorros=" + cachorros + "]";
	}

}
