package com.notimplement.happygear.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notimplement.happygear.model.dto.AccountDto;
import com.notimplement.happygear.model.dto.BrandDto;
import com.notimplement.happygear.model.dto.CategoryDto;
import com.notimplement.happygear.model.dto.ProductDto;
import com.notimplement.happygear.model.dto.RoleDto;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.service.BrandService;
import com.notimplement.happygear.service.CategoryService;
import com.notimplement.happygear.service.ProductService;
import com.notimplement.happygear.service.RoleService;
import com.notimplement.happygear.service.UserService;

//@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminApi {
	
	@Autowired
	BrandService brandService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
    RoleService roleService;
	@Autowired
    private UserService userService;
	
	//=====================Brand======================================

	@GetMapping("/brands")
	public ResponseEntity<?> listAllBrand(){
		return ResponseEntity.ok(brandService.listAll());
	}
	
	@GetMapping("/brands/{id}")
	public ResponseEntity<?> getBrandById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(brandService.getById(id));
	}
	
	@PostMapping("/brands/create")
	public ResponseEntity<?> createBrand(@Valid @RequestBody BrandDto brand){
		return ResponseEntity.ok(brandService.create(brand));
	}
	
	@PutMapping("/brands/update/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable(name ="id") Integer id ,@Valid @RequestBody BrandDto brand){
		brand.setBrandId(id);
		return ResponseEntity.ok(brandService.update(brand));
	}
	
	@DeleteMapping("/brands/delete/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(brandService.delete(id));
	}

	//=====================Category======================================

	@GetMapping("/categories")
	public ResponseEntity<?> listAllCategory(){
		return ResponseEntity.ok(categoryService.listAll());
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(categoryService.getById(id));
	}
	
	@PostMapping("/categories/create")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto Category){
		return ResponseEntity.ok(categoryService.create(Category));
	}
	
	@PutMapping("/categories/update/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable(name ="id") Integer id ,@Valid @RequestBody CategoryDto cate){
		cate.setCategoryId(id);
		return ResponseEntity.ok(categoryService.update(cate));
	}
	
	@DeleteMapping("/categories/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(categoryService.delete(id));
	}

	//=====================Product======================================

	@GetMapping("/products")
	public ResponseEntity<?> listAllProduct(){
		return ResponseEntity.ok(productService.listAll());
	}
	
	@GetMapping("/products/total")
	public ResponseEntity<?> totalProduct(){
		return ResponseEntity.ok(productService.totalProduct());
	}

	@GetMapping("/products/")
	public ResponseEntity<?> listProductByPage(@RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0),9);
		Map<List<ProductDto>, Integer> listIntegerMap = productService.listByPage(pageable);
		List<Object> list = new ArrayList<>();
		listIntegerMap.forEach((productDtos, integer) -> {
			list.add(productDtos);
			list.add(integer);
		});
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/products/name")
	public ResponseEntity<?> listProductByPageAndName(@RequestParam("name") String name,
													  @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0),9);
		Map<List<ProductDto>, Long> listIntegerMap = productService.listByPageAndName(name, pageable);
		List<Object> list = new ArrayList<>();
		listIntegerMap.forEach((productDtos, integer) -> {
			list.add(productDtos);
			list.add(integer);
		});
		return ResponseEntity.ok(list);
	}

	@GetMapping("/products/search")
	public ResponseEntity<?> listProductBySearch(@RequestParam("p") Optional<Integer> p,
												 @RequestParam("text") Optional<String> text){
		Pageable pageable = PageRequest.of(p.orElse(0),9);
		Map<List<ProductDto>, Integer> listIntegerMap =
				productService.listProductByName(text.orElse(""), pageable);
		List<Object> list = new ArrayList<>();
		listIntegerMap.forEach((productDtos, integer) -> {
			list.add(productDtos);
			list.add(integer);
		});
		return ResponseEntity.ok(list);
	}

	@GetMapping("/products/page")
	public ResponseEntity<?> listProductByPageAndCatgoryAndBrand(@RequestParam("p") Optional<Integer> p,
																 @RequestParam("b") Optional<Integer> brandId,
																 @RequestParam("c") Optional<Integer> categoryId,
																 @RequestParam("f") Double fromPrice,
																 @RequestParam("t") Double toPrice){
		Pageable pageable = PageRequest.of(p.orElse(0),9);
		Map<List<ProductDto>, Integer> listIntegerMap =
				productService.listByPageCategoryAndBrand(brandId.orElse(1),
						categoryId.orElse(1), fromPrice, toPrice, pageable);
		List<Object> list = new ArrayList<>();
		listIntegerMap.forEach((productDtos, integer) -> {
			list.add(productDtos);
			list.add(integer);
		});
		return ResponseEntity.ok(list);
	}

	@GetMapping("/products/best-seller")
	public ResponseEntity<?> listTop5ProductByQuanity(){
		List<ProductDto> list = productService.listAllProductWithMinQuantity();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/products/latest")
	public ResponseEntity<?> listLatestProduct(){
		List<ProductDto> list = productService.listAllLatestProduct();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(productService.getById(id));
	}
	
	@PostMapping("/products/create")
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto Product){
		return ResponseEntity.ok(productService.create(Product));
	}
	
	@PutMapping("/products/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name ="id") Integer id ,@Valid @RequestBody ProductDto p){
		p.setProductId(id);
		return ResponseEntity.ok(productService.update(p));
	}
	
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(productService.delete(id));
	}

	//=====================Role======================================

    @GetMapping("/roles")
    public ResponseEntity<?> getAllRole(){
        List<RoleDto> listRole = roleService.getAllRoleDto();
        return ResponseEntity.ok(listRole);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Integer id){
        RoleDto roleDto = roleService.getRoleById(id);
        return ResponseEntity.ok(roleDto);
    }

    @PostMapping("/roles/create")
    public ResponseEntity<?> createRole(@RequestBody RoleDto roleDto){
        RoleDto newRoleDto = roleService.createRole(roleDto);
        return ResponseEntity.ok(newRoleDto);
    }

    @DeleteMapping("/roles/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id){
        RoleDto deleteDto = roleService.removeRole(id);
        return ResponseEntity.ok(deleteDto);
    }

    @PutMapping("/roles/update/{id}")
    public ResponseEntity<?> updateRole(@RequestBody RoleDto roleDto, @PathVariable Integer id){
        RoleDto updateRole = roleService.updateRole(roleDto,id);
        return ResponseEntity.ok(updateRole);
    }

	//======================User===============================

	@GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        List<UserDto> listUser = userService.getAllActiveUser();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUserByUserName(@PathVariable(name = "username") String username){
        UserDto userDto = userService.getByUserName(username);
        if(userDto==null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(userDto);
    }
    
    @GetMapping("/users/")
    public ResponseEntity<?> getAllByPage(@RequestParam("p") Optional<Integer> p){
    	Pageable pageable = PageRequest.of(p.orElse(0), 8);
    	Map<List<UserDto>, Long> listMap = userService.listByPage(pageable);
    	List<Object> list = new ArrayList<>();
    	listMap.forEach((userDtos, count)->{
    		list.add(userDtos);
    		list.add(count);
    	});
    	return ResponseEntity.ok(list);
    }

    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        UserDto newUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(newUserDto);
    }

    @DeleteMapping("/users/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "username") String username){
        UserDto deletedUserDto = userService.deleteUser(username);
        return ResponseEntity.ok(deletedUserDto);
    }

    @PutMapping("/users/update/{username}")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable(name = "username") String username){
        UserDto updateUserDto = userService.updateUser(userDto, username);
        return ResponseEntity.ok(updateUserDto);
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody AccountDto accountDto){
        UserDto userDto = userService.loginAcc(accountDto);
        if(userDto!=null)
            return ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/users/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        UserDto user = userService.signupAcc(userDto);
        return ResponseEntity.ok(user);
    }
}
