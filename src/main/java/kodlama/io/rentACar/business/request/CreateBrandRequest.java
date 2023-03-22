package kodlama.io.rentACar.business.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//response requstpattern
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
	@NotNull												// ben simdi bu name alanına veri girilmesini istiyorum . gerekli alan 
	@NotBlank
	@Size(min = 3,max = 20) 
	private String name;
}
