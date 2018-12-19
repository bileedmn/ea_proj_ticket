package edu.mum.dao;

import edu.mum.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MemberRepo extends CrudRepository<Member,Long> {
}
