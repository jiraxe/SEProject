package swe425.project.MIUScheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swe425.project.MIUScheduler.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username LIKE :username and u.password Like :password")
    User searchUsers(@Param("username") String username, @Param("password") String password);
    @Query("SELECT t FROM User t where t.username = :userName")
    User findByUsername(String userName);
}
