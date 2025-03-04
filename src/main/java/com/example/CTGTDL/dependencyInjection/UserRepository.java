//package com.example.CTGTDL.dependencyInjection;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface UserRepository extends JpaRepository<Long,U> {
//    User findByName(String name);
//    User findNameAndAge(String name, int age);
//    @Query("from User u where u.name =:name")
//    User findUser(@Param("name") String name);
//}
