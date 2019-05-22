package fi.haagahelia.BookstoreNew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.BookstoreNew.domain.BookNew;
import fi.haagahelia.BookstoreNew.domain.BookNewRepository;

@Controller
public class BookNewController {


	@GetMapping("/index")
	 public String index() {
		 
		 return "index";
	 }
	@Autowired
	private BookNewRepository repository;
	@GetMapping("/booklist")
	public String BookList(Model model) {
		model.addAttribute("Books", repository.findAll());
		return "booklist";
		}

	@RequestMapping(value= "/add")
	public String addBookNew(Model model) {
		model.addAttribute("Books", new BookNew());
		return "addBookNew";
		}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save (BookNew booknew) {
		
		repository.save(booknew);
		return "redirect:boolist";
		
	}
	

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id")int id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}
	
	
	
}
