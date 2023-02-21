package jana60.repository;


import org.springframework.data.repository.CrudRepository;
import jana60.model.FreeForAll;
import java.util.List;


public interface MoreStuffRepository extends CrudRepository<FreeForAll,Integer> {

}
