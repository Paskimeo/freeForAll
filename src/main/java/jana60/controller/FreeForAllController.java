package jana60.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jana60.model.FreeForAll;
import jana60.repository.FreeForAllRepository;




@Controller
@RequestMapping("/")
public class FreeForAllController 
{

	@Autowired
	private FreeForAllRepository repo;
	
	
	 @GetMapping
	  public String saluta() 
	  {
	    return "/Freedom/home";
	  }
	
	
	
	
}
