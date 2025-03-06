package com.example.taskmaneger.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmaneger.entity.Users;
import com.example.taskmaneger.payload.UserDto;
import com.example.taskmaneger.repo.Userrepo;
import com.example.taskmaneger.service.UserService;
@Service
public class UseServiceimpl implements UserService{
   @Autowired
	Userrepo userrepo;
	@Override
	public UserDto createuser(UserDto userdto) {
		
	  Users saved=DtotoUser(userdto);
	 Users sav= userrepo.save(saved);
	 return usertoDto(sav);
	}
	private Users DtotoUser(UserDto userdto) {
		Users us=new Users();
		us.setName(userdto.getName());
		us.setEmail(userdto.getEmail());
		us.setPassword(userdto.getPassword());
		
		return us;
	}
	private UserDto usertoDto(Users us) {
		UserDto ud=new UserDto();
		ud.setId(us.getId());
		ud.setName(us.getName());
		ud.setEmail(us.getEmail());
		ud.setPassword(us.getPassword());
		
		return ud;
	}

}
