package datn.goodboy.controller.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import datn.goodboy.model.entity.Category;
import datn.goodboy.service.CategoryService;

@ControllerAdvice
public class GlobalControllerAdvice {
  @Autowired
  CategoryService categoryService;

  @ModelAttribute("categories")
  public List<Category> getCategories() {
    return categoryService.getAllCartDetail();
  }
}
