package it.nextre.prova1.Repository;

import it.nextre.prova1.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
