package org.martoni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordContoller {

	@Autowired
	private WordRepository wordRepo; 


	@RequestMapping("/practice")
	public String practice(@RequestParam(value="p1", required=false) String param,
			@ModelAttribute Word word,
			Model model) {
		model.addAttribute("p1", param);
		word = new Word("Hi","Szia");
		model.addAttribute("word", word);
		return "practice";
		
	}
	@RequestMapping("/getWords")
	public @ResponseBody Iterable<Word> getWords(@RequestParam(name="count", required=false, defaultValue="5") Integer count) {
		return this.wordRepo.findTop5ByOrderByUsageAsc();
	}
	
}
