package cf.stock;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "stockService", path = "stockService")
public interface StockRepository extends CrudRepository<Stock, Long> {

	List<Stock> findBySymbolIgnoreCase(@Param("symbol") String symbol);

}