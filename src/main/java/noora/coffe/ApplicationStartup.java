package noora.coffe;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Component;

/**  */
import noora.coffe.entity.*;
import noora.coffe.repos.*;
import noora.coffe.services.*;

/**  */

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	// DepartmentService
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DepartmentRepo departmentRepo;

	// ProductService
	@Autowired
	ProductService productService;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	SupplierService supplierService;

	/** -------------------------- */

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {

		this
			.makeFakeDepartments()
			.makeFakeSuppliers()
			.makeFakeMakers()
			.makeFakeProduct();
	}

	

	@Transactional
	private ApplicationStartup makeFakeDepartments() {
		// String noCategory = "No Category";
		String kahvilaitteet = "Kahvilaitteet";
		String kulutustuoteet = "Kulutustuoteet";

		// if (!departmentRepo.existsByName(noCategory)) {
		// System.out.println("INSERT " + noCategory);
		// departmentRepo.save(new Department(noCategory));
		// }

		if (!departmentRepo.existsByName(kahvilaitteet)) {
			System.out.println("INSERT " + kahvilaitteet);
			departmentRepo.save(new Department(kahvilaitteet));
		}

		if (!departmentRepo.existsByName(kulutustuoteet)) {
			System.out.println("INSERT " + kulutustuoteet);
			departmentRepo.save(new Department(kulutustuoteet));
		}

		return this;
	}

	private String productDescription() {
		return "Lorem Ipsum is simply dummy text of the printing and typesetting industry" +
				"Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" +
				"when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

	}


	
	@Transactional
	private ApplicationStartup makeFakeProduct() {

		if (productRepo.findAll().size() != 0) {
			return this;
		}
		System.out.println("==================");
		System.out.println(" INSERT PRODUCS ................");
		for (int i = 0; i <= 10; i++) 
		{
			int max = 99;
			int min = 0;
			int range = max - min + 1;

			int euro = (int) (Math.random() * range) + min;
			int cent = (int) (Math.random() * range) + min;

			Product product = new Product(
						i + "_TEST_PRODUCT_" + i,
						this.productDescription(),
						euro,
						( euro == 0 ) ? euro + 10 : cent
					);
			
			productService.addProduct( product );
		}
		return this;
	}

	@Transactional
	private ApplicationStartup makeFakeSuppliers() {

		if (supplierRepo.findAll().size() != 0) {
			return this;
		}

		// Supplier no_supplier = new Supplier("No Supplier", null, null, null);
		Supplier s_market = new Supplier("S-MARKET", "Jussi Pekkala", "jussi@s-market.fi", null);
		Supplier k_market = new Supplier("K-MARKET", "Matti Holstrom", "matti@k-market.fi", null);
		Supplier prisma = new Supplier("PRISMA", "Henna Suomalainen", "henna@prisma.fi", null);

		// supplierService.addNewSupplier(no_supplier);

		supplierService.add(s_market);
		supplierService.add(k_market);
		supplierService.add(prisma);

		return this;
	}

	private ApplicationStartup makeFakeMakers() {
		if (supplierRepo.findAll().size() != 0) {
			return this;
		}
		return this;
	}

}