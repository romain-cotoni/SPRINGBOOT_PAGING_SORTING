package fr.springboot.pagingsorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.springboot.pagingsorting.model.AppModel;
import fr.springboot.pagingsorting.service.AppService;

@RestController
@RequestMapping("/api/listener")
public class AppController {

	private static int count = 0; 
	
	@Autowired
	private AppService appService;
	
	@GetMapping("")
	public Iterable<AppModel> getEntities() {
		return appService.getEntities();
	}
	
	/**
	 * Find all and paging
	 * @param nbOfPage
	 * @param offset
	 * @return
	 */
	@GetMapping("/{nbOfPage}/{offset}")
	public Iterable<AppModel> getEntitiesPaging(@PathVariable int nbOfPage,@PathVariable int offset){
		return appService.getEntitiesPaging(nbOfPage,offset);
	}
	
	/**
	 * Find all and sorting
	 * @return
	 */
	@GetMapping("/sorting/{attribute}")
	public Iterable<AppModel> getEntitiesSorting(@PathVariable String attribute){
		return appService.getEntitiesSorting(attribute);
	}
	
	/**
	 * Find all and paging and sorting
	 * @param nbOfPage
	 * @param offset
	 * @return
	 */
	@GetMapping("/{nbOfPage}/{offset}/{attribute}")
	public Iterable<AppModel> getEntitiesPagingAndSorting(@PathVariable int nbOfPage,@PathVariable int offset,@PathVariable String attribute){
		return appService.getEntitiesPagingAndSorting(nbOfPage,offset,attribute);
	}
	
	@GetMapping("/{id}")
	public AppModel getEntity(@PathVariable int id) throws Exception {
		return appService.getEntity(id);
	}
	
	@PostMapping("")
	public AppModel createEntity() throws Exception {
		AppModel appModel = new AppModel("hellolistener "+(++count),count);
		return appService.createEntity(appModel);
	}
	
	@PatchMapping("/{id}")
	public AppModel updateEntity(@PathVariable int id) throws Exception {
		AppModel appModel = new AppModel("hellolistenerUpdated "+(++count),count);
		return appService.updateEntity(id, appModel);
	}
	
}
