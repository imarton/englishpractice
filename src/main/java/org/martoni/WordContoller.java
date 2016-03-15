package org.martoni;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordContoller {
	
	
//	public String getWord(@PathVariable String word) {
//		return word;
//	}
	
	@RequestMapping("/greeting")
	public String greeting(Model model) {
		model.addAttribute("name", "Idegen");
		return "greeting";
	}
	
	@RequestMapping("/practice")
	public String practice(@RequestParam(value="p1", required=false) String param,
			@ModelAttribute Word word,
			Model model) {
		model.addAttribute("p1", param);
		word = new Word("Hi","Szia");
		model.addAttribute("word", word);
		return "practice";
		
	}
	
}
