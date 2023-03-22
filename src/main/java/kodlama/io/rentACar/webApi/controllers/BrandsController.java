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

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController // annotation bilgilendirme ifadesidir 
@RequestMapping("/api/brands") //adresimizin sonunu api/brands derse burayı ifade ediyor demek adresleme 
@AllArgsConstructor
public class BrandsController { // api isimlendirmesinde cogul kullanılır http keyword kaynaklı 

	private BrandService brandService;
//@Autowired // git paremetrelerine bak brand service git uygulamayı tara kin bu brand serviceyi implemente etti onun newlenmiş halini bana ver 
//public BrandsController(BrandService brandService) {
//	this.brandService = brandService;
//}
	@GetMapping()  //www.kodlama.io/api/brands/getAll diyince sen calısssss // kısaca data çekmek için 
	public List<GetAllBrandResponses> getAll(){
		// IOC 
		
		return brandService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {// path den al
		return brandService.getById(id);
	
	}	
	@PostMapping() // eklemeler için kullan
	@ResponseStatus(code=HttpStatus.CREATED)// 201 dondursun 
	public void add(@RequestBody @Valid() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest); 
	}
	@PutMapping() // update islemi
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}
