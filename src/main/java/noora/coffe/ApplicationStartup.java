package noora.coffe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import noora.coffe.entity.Department;
import noora.coffe.repos.DepartmentRepo;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        this.makeDepartments();

        return;
    }

    private void makeDepartments() 
    {    
        String noCategory = "No Category";
        String kahvilaitteet = "Kahvilaitteet";
        String kulutustuoteet = "Kulutustuoteet";
        
        if( ! departmentRepo.existsByName(noCategory) ){
            System.out.println("INSERT " + noCategory);
            departmentRepo.save( new Department(noCategory) );
        }

        if( ! departmentRepo.existsByName(kahvilaitteet) ){
            System.out.println("INSERT " + kahvilaitteet);
            departmentRepo.save( new Department( kahvilaitteet ) );
        }

        if( ! departmentRepo.existsByName(kulutustuoteet) ){
            System.out.println("INSERT " + kulutustuoteet);
            departmentRepo.save( new Department(kulutustuoteet) );
        }
    }
}