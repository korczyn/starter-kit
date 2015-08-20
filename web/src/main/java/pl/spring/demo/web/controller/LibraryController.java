package pl.spring.demo.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

@Controller
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	 @RequestMapping(value = "/libDelete", method = RequestMethod.GET)
	 public String deleteLibrary(@RequestParam("id") Long id, Map<String, Object> params){
		 libraryService.deleteLibrary(id);
		 return "home";
	 }
	 
	 @RequestMapping(value = "/libs", method = RequestMethod.GET)
	    public String libList(Map<String, Object> params) {
	        final List<LibraryTo> allLibs = libraryService.findAllLibs();
	        params.put("libs", allLibs);
	        return "libList";
	    }
	 
	 @RequestMapping(value = "/libByName", method = RequestMethod.GET)
	 public String findLibraryByName(@RequestParam("name") String name, Map<String, Object> params){
		 final List<LibraryTo> libs = libraryService.findLibraryByName(name);
		 params.put("libs", libs);
		 return "libList";
	 }
	 
}
