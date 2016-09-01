import javax.persistence.*;

@Entity
@Table(name = "album")
@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", initialValue = 1, allocationSize = 53)
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
	private int id;
	private String titulo;
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
