package noora.coffe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import noora.coffe.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByName( String name );
    Boolean existsByName( String name );




    // default <S> boolean addNewDepartment(String department) {
        
    //     Department result = findByName( department ); 
        
    //     if( result == null ){

    //         save( new Department( department, 0 )  );

    //         return true;
    //     }

    //     return false;
    // }

   


   
}
