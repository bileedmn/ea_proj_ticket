package edu.mum.dao;

import edu.mum.entity.UserCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by: Ganbat Bayar
 * On: 12/17/2018
 * Project: Ticket_Booker
 */
@SuppressWarnings("unchecked")
@Repository
public interface UserCredentialsDAO extends CrudRepository<UserCredentials, String> {

    UserCredentials findByUsername(String username);
}
