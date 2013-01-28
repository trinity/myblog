package org.nuclearzone.myblog.repository;

import org.bson.types.ObjectId;
import org.nuclearzone.myblog.domain.AbstractBlogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository<T extends AbstractBlogEntity> extends MongoRepository<T, ObjectId> {

}
