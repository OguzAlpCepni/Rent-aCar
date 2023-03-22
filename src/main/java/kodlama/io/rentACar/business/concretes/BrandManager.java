package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.Rules.BrandBusinessRules;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
																								// IOC nedir git bellekte bir şeyi newle bellekte yer ayır isteyene o referansı ver 
@Service    																					// bu sınıf bir business nesnesidir 
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
																							//@Autowired yazmasakta olur 
																							//public BrandManager(BrandRepository brandRepository) {
																							//	this.brandRepository = brandRepository;
																							//}
	@Override
	public List<GetAllBrandResponses> getAll() {
																							// iş kuralları yaz 	
			List<Brand> brands = brandRepository.findAll(); 								// bu tipi yukardaki tipe çevirmem lazım 
			
			List<GetAllBrandResponses> brandsResponse = brands.stream().map(brand->this.modelMapperService.forResponse().map(brand,GetAllBrandResponses.class)).collect(Collectors.toList());// elimizde bir liste varsa onu tekte dolaşmamızı sağlıyor 
		return brandsResponse;																																	// üstteki yer collect bunları topla ve su türe çevir 						
	}
																								// mapper mesela Brand'i GetAllBrandResponsete dönüştürüyor gibi düşünebilirsin
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());																						//Brand brand = new Brand(); önceki durum mappersiz
																								//brand.setName(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);// neyi neye map edeyim
																								// üstteki kodda forRequest arka planda brand i newliyor sonra createBrandRequest bunun bütün alanlarını tek tek karşılaştırıyor aynı olanları o newlediğine aktarıyor artık elimde bir veri tabanı nesnesi var 
		this.brandRepository.save(brand);
	}
	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse Response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return Response;
	}
	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}
	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

	
}
