package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	// iş kurallarının olacağı yapılar
	// response requent pattern ===?????
	
	List<GetAllBrandResponses> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);//:)
}
