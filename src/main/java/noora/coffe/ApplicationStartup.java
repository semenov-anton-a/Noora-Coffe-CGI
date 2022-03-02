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

	@Transactional
	private ApplicationStartup makeFakeProduct() {

		if (productRepo.findAll().size() != 0) {
			return this;
		}

		System.out.println("==================");
		System.out.println(" INSERT PRODUCS ................");

		Product p_0 = new Product(
				"0_product_0", null);
		productService.save(p_0);

		Product p_1 = new Product(
				"1_product_1", null);
		productService.save(p_1);

		Product p_2 = new Product(
				"2_product_2",
				departmentRepo.getById(1L));
		productService.save(p_2);

		Product p_3 = new Product(
				"3_product_3",
				departmentRepo.getById(1L));
		productService.save(p_3);

		Product p_4 = new Product(
				"4_product_4",
				departmentRepo.getById(2L));
		productService.save(p_4);

		Product p_5 = new Product(
				"5_product_5",
				departmentRepo.getById(2L));
		productService.save(p_5);

		Product p_6 = new Product(
				"6_product_6",
				null);
		productService.save(p_6);

		Product p_7 = new Product(
				"7_product_7",
				departmentRepo.getById(2L));
		productService.save(p_7);

		Product p_8 = new Product(
				"8_product_8",
				departmentRepo.getById(2L));
		productService.save(p_8);

		Product p_9 = new Product(
				"9_product_9",
				departmentRepo.getById(1L));
		productService.save(p_9);
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


		// Maker 


		return this;
	}

}