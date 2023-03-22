package kodlama.io.rentACar.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
	private int id;
	private String name;
	private int brandId;
}
