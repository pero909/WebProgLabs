import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }
    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream()
                .filter(m->m.getId().equals(id))
                .findFirst();
    }
    public Optional<Manufacturer> findByName(String Name){
        return DataHolder.manufacturers.stream()
                .filter(m->m.getName().equals(Name))
                .findFirst();
    }


}
