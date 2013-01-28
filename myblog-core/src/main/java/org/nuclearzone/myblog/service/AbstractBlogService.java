package org.nuclearzone.myblog.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.nuclearzone.myblog.domain.AbstractBlogEntity;
import org.nuclearzone.myblog.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public abstract class AbstractBlogService<T extends AbstractBlogEntity> {
			
	public T save(T entity) {
		return getRepository().save(entity);
	}
	
	public T findById(ObjectId id) {
		return getRepository().findOne(id);
	}
	
	public Page<T> findAll(PageRequest pageRequest) {
		return getRepository().findAll(pageRequest);
	}
	
	public List<T> findAll() {
		return getRepository().findAll();
	}
	
	public void delete(T entity) {
		getRepository().delete(entity);
	}
	
	public void delete(ObjectId id) {
		getRepository().delete(id);
	}
	
	protected abstract BlogRepository<T> getRepository();
}
