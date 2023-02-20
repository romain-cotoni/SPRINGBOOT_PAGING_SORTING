package fr.springboot.pagingsorting.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.springboot.pagingsorting.model.AppModel;
import fr.springboot.pagingsorting.repository.AppRepository;
import jakarta.transaction.Transactional;

@Service
public class AppService {

	@Autowired
	private AppRepository appRepository;

	public Iterable<AppModel> getEntities() {
		return appRepository.findAll();
	}
	
	public AppModel getEntity(int id) throws Exception {
		return appRepository.findById(id).get();		
	}
	
	/**
	 * Paging
	 * @param offset
	 * @param pagesize
	 * @return Iterable
	 */
	public Iterable<AppModel> getEntitiesPaging(int offset,int pagesize) {
		return appRepository.findAll(PageRequest.of(offset,pagesize));
	}
	
	/**
	 * Sorting
	 * @param attribute
	 * @return Iterable
	 */
	public Iterable<AppModel> getEntitiesSorting(String attribute) {
		return appRepository.findAll(Sort.by(Sort.Order.desc(attribute)));
	}
	
	/**
	 * Paging and Sorting
	 * @param offset
	 * @param pagesize
	 * @return Iterable
	 */
	public Iterable<AppModel> getEntitiesPagingAndSorting(int offset,int pagesize,String attribute) {
		return appRepository.findAll(PageRequest.of(offset,pagesize,Sort.by(Sort.Order.desc(attribute))));
	}

	public AppModel createEntity(AppModel appModel) throws Exception {
	    return appRepository.save(appModel);
	}

	@Transactional
	public AppModel updateEntity(int id, AppModel appModel) throws Exception {
		AppModel appModelToModify = appRepository.findById(id).orElseThrow();
		appModelToModify.setLabel(appModel.getLabel());
		appModelToModify.setLevel(appModel.getLevel());
		appModelToModify.setLastModified(new Date());
		return appRepository.save(appModelToModify);
	}


}
