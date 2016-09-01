import javax.persistence.*;

@Entity
@Table(name = "tb_music")
@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", initialValue = 1, allocationSize = 53)
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
	private int id;
	
	@Basic(optional = false)
	@Column(name = "NM_MUSICA", length = 100, unique = true)
	private String nome;
	
	@ManyToOne
	private Album album;
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
