package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "brands")									// bu bir brand tablosudur
@Data													// getter setter ve diger gerekli butun metodlarını getir lombok
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	
	@Id 												// sen primarykeysin
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ıd otomatik arttılır bir bir arttır  
	@Column(name="id") 									// sen tabloda id sutununa aitsin
	private int id;
	@Column(name="name")								// sen isim sutununa aitsin
	private String name;
	
	@OneToMany(mappedBy = "brand")						// model ilişkilendirilmesinde hangi alanla ilişkilendirelecek
	private java.util.List<Model>models;
	
	
}
