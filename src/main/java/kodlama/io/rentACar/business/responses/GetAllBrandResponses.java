package kodlama.io.rentACar.business.responses;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponses {
	@NotNull												// ben simdi bu name alanına veri girilmesini istiyorum . gerekli alan 
	@NotBlank
	@Size(min = 3,max = 20) 
	private int id;
	@NotNull												// ben simdi bu name alanına veri girilmesini istiyorum . gerekli alan 
	@NotBlank
	@Size(min = 3,max = 20) 
	private String name;
}
