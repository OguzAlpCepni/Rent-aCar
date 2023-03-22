package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.request.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {

	List<GetAllModelsResponse>getAll();
	void add(CreateModelRequest createModelRequest); 
	GetByIdModelResponse getById(int id);
	void Update(UpdateModelRequest updateModelRequest);
	void delete(int id);
}
