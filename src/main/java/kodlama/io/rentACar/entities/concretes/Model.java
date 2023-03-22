package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "models")									// bu bir brand tablosudur
@Data													// getter setter ve diger gerekli butun metodlarını getir lombok
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
	@Id 												// sen primarykeysin
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ıd otomatik arttılır bir bir arttır  
	@Column(name="id") 									// sen tabloda id sutununa aitsin
	private int id;
	@Column(name="name")								// sen isim sutununa aitsin
	private String name;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@OneToMany(mappedBy = "model")
	private List<Car> cars; 
}
