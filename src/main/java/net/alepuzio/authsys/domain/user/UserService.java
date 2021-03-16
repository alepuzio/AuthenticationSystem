package net.alepuzio.authsys.domain.user;

import org.springframework.beans.factory.annotation.Autowired;

import net.alepuzio.authsys.domain.user.persistence.JDBCRepository;
import net.alepuzio.authsys.domain.user.persistence.Persistent;

public class UserService {

	@Autowired
	private JDBCRepository jdbcRepository = null;
	
	
	public Persistent save(Generic genericToSave) throws Exception{
		return jdbcRepository.save(genericToSave);
	}
}
