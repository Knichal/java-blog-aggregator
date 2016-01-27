package pl.mknichal.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.mknichal.jba.entity.Blog;
import pl.mknichal.jba.entity.Item;
import pl.mknichal.jba.entity.Role;
import pl.mknichal.jba.entity.User;
import pl.mknichal.jba.repository.BlogRepository;
import pl.mknichal.jba.repository.ItemRepository;
import pl.mknichal.jba.repository.RoleRepository;
import pl.mknichal.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	@PostConstruct
	public void init() {

		if (roleRepository.findByName("ROLE_ADMIN") == null) {

			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
			
			User userAdmin = new User();
			userAdmin.setEnabled(true);
			userAdmin.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();

			roles.add(roleAdmin);
			roles.add(roleUser);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);

			Blog blogJavavids = new Blog();
			blogJavavids.setName("Android.com.pl");
			blogJavavids.setUrl("http://android.com.pl/feed/");
			blogJavavids.setUser(userAdmin);
			blogRepository.save(blogJavavids);
//
//			Item item1 = new Item();
//			item1.setBlog(blogJavavids);
//			item1.setTitle("Test1");
//			item1.setLink("http://google.pl");
//			item1.setPublishedDate(new Date());
//			itemRepository.save(item1);
//
//			Item item2 = new Item();
//			item2.setBlog(blogJavavids);
//			item2.setTitle("Test2");
//			item2.setLink("http://google.pl");
//			item2.setPublishedDate(new Date());
//			itemRepository.save(item2);
		}

	}
}
