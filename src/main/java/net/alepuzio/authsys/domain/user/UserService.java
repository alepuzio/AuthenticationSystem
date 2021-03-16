package net.alepuzio.authsys.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.domain.user.persistence.JDBCRepository;

@Component
public class UserService {

	@Autowired
	private JDBCRepository jdbcRepository;
	
	public Generic save(Generic genericToSave) throws Exception{
		return jdbcRepository.save(genericToSave);
	}
	
	public Generic recordedData(Generic genericToRead) throws Exception {
		return jdbcRepository.user(genericToRead);
	}

}
