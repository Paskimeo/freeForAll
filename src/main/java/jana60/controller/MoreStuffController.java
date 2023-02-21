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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.FieldError;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import jana60.model.FreeForAll;
import jana60.repository.FreeForAllRepository;
import jana60.repository.MoreStuffRepository;



@Controller
@RequestMapping("/Freedom/moreStuff")
public class MoreStuffController {

	@Autowired
	private FreeForAllRepository repo2;
	
	@Autowired
	private MoreStuffRepository repo;
	
	
	 @GetMapping
	  public String moreStuff(Model model)
	 {
		 
		 List<FreeForAll> ListSub = (List<FreeForAll>) repo.findAll();
		 
		 model.addAttribute("ListSub", ListSub);
		 
		 return "/Freedom/moreStuff";
		 
		
	 }
	 
	 
	 @GetMapping("/add")
		public String SubForm(Model model) {
		 model.addAttribute("NuovoOggetto",new FreeForAll());
			return "/Freedom/add";
	
	 }
	 
	 @PostMapping("/save")
	  public String save(@Valid @ModelAttribute("NuovoOggetto") FreeForAll formSub,BindingResult br) {
	   
		 if(br.hasErrors()) {
			 return "/Freedom/add";
		 }
		 
	      repo.save(formSub);
	      return "redirect:/Freedom/moreStuff";
	    }
		 
	 
	 // request a http://localhost:8080/delete/2
	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable("id") Integer subId, RedirectAttributes ra) {
	    	java.util.Optional<FreeForAll> result = repo.findById(subId);
	    	if (result.isPresent()) {
	    	      // repo.deleteById(NicknameId);
	    	      repo.delete(result.get());
	    	      ra.addFlashAttribute("successMessage", "nickname " + result.get().getGenerico() + " deleted!");
	    	      return "redirect:/Freedom/moreStuff";
	    	    } else 
	    	    {
	    	      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
	    	          "Nickname con id " + subId + " not present");
	    } 
	    }
	    
	    
		 @GetMapping("/edit/{id}")
   	  public String edit(@PathVariable("id") Integer subId, Model model) {
   	    java.util.Optional<FreeForAll> result = repo.findById(subId);
   	    // controllo se il Book con quell'id è presente
   	    if (result.isPresent()) {
   	      // preparo il template con al form passandogli il book trovato su db

   	      model.addAttribute("NuovoOggetto", result.get());
   	      return "/Freedom/add";
   	    } else {
   	      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
   	          "Book con id " + subId + " not present");
   	    }
	    
	    
	    
	    
		 }
	    }

