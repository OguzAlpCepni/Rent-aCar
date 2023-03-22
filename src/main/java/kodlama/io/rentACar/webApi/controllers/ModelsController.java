package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.request.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController // annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

	//IOC
	private ModelService modelService;
	
	@GetMapping()
	public List<GetAllModelsResponse>getAll(){
		return modelService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	@PutMapping
	public void Update(@RequestBody @Valid() UpdateModelRequest updateModelRequest) {
		this.modelService.Update(updateModelRequest);
	}
	@GetMapping("/{id}")
	public void GetById(@PathVariable int id) {
		this.modelService.getById(id);
	}
	@DeleteMapping(("/{id}"))
	public void Delete(@PathVariable int id) {
		this.modelService.delete(id);
	}
	
}
