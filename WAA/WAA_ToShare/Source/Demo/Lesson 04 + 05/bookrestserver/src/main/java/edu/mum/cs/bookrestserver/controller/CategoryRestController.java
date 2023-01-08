package edu.mum.cs.bookrestserver.controller;

import javax.validation.Valid;

import edu.mum.cs.bookrestserver.domain.Category;
import edu.mum.cs.bookrestserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    // @Valid - but NO BindResult! an exception will be thrown...
    @CrossOrigin(origins = {"http://localhost:9080", "http://localhost:9000"}, maxAge = 6000)
    @PostMapping(value = "/api/category", produces = "application/json")
    public Category saveCategory(@Valid @RequestBody Category category) {
        category.setDescription("This is default description...");
        categoryService.save(category);
        return category;
    }

    @PutMapping("api/category")
    public Category updateCat( @RequestBody Category category){
        categoryService.update(category);
        return category;
    }

}
