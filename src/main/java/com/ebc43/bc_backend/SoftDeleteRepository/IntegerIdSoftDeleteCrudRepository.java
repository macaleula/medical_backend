package com.ebc43.bc_backend.SoftDeleteRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;

@NoRepositoryBean
public interface IntegerIdSoftDeleteCrudRepository<T extends IntegerIdAbstractEntity, ID> extends CrudRepository<T, ID> {
  @Query("select e from #{#entityName} e where e.deletedAt IS NULL")
  List<T> findAll();

  @Query("select e from #{#entityName} e where e.id in ?1 and e.deletedAt IS NULL")
  Iterable<T> findAll(Iterable<ID> ids);

  @Query("select e from #{#entityName} e where e.id = ?1 and e.deletedAt IS NULL")
  T findOne(ID id);

  //Look up deleted entities
  @Query("select e from #{#entityName} e where e.deletedAt IS NOT NULL")
  List<T> findInactive();

  @Query("select count(e) from #{#entityName} e where e.deletedAt IS NULL")
  long count();

  default boolean exists(ID id) {
      return findOne(id) != null;
  }

  @Query("update #{#entityName} e set e.deletedAt=CURRENT_TIMESTAMP where e.id = ?1")
  @Transactional
  @Modifying
  void delete(Integer id);


  @Transactional
  default void delete(T entity) {
      delete(entity.getId());
  }

  @Transactional
  default void delete(Iterable<? extends T> entities) {
      entities.forEach(entitiy -> delete(entitiy.getId()));
  }

  @Override
  @Query("update #{#entityName} e set e.deletedAt=CURRENT_TIMESTAMP")
  @Transactional
  @Modifying
  void deleteAll();
}
