package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "cars") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "plate")
	private String plate;
	
	@Column(name = "dailyPrice")
	private double dailyPrice;
	
	@Column(name = "modelYear")
	private int modelYear;
	
	@Column(name = "state")
	private int state; 				// 1-avaible 2-rented 3-maintanence 
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
}
