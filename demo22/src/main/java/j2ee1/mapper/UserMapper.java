package j2ee1.mapper;

import com.example.j2ee1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);

    List<User> findAllByIsLoginTrue();
}
