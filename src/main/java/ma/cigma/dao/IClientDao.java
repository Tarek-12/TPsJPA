package ma.cigma.dao;

import ma.cigma.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClientDao extends CrudRepository<Client,Long> {
}
