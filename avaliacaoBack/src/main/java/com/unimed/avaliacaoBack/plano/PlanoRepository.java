package com.unimed.avaliacaoBack.plano;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;


@Repository
public class PlanoRepository implements PlanoInterface {

	@Override
	public void flush() {
	
	}

	@Override
	public <S extends Plano> S saveAndFlush(S entity) {
				return null;
	}

	@Override
	public <S extends Plano> List<S> saveAllAndFlush(Iterable<S> entities) {
				return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Plano> entities) {
				
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
				
	}

	@Override
	public void deleteAllInBatch() {
				
	}

	@Override
	public Plano getOne(Long id) {
				return null;
	}

	@Override
	public Plano getById(Long id) {
				return null;
	}

	@Override
	public Plano getReferenceById(Long id) {
				return null;
	}

	@Override
	public <S extends Plano> List<S> findAll(Example<S> example) {
				return null;
	}

	@Override
	public <S extends Plano> List<S> findAll(Example<S> example, Sort sort) {
				return null;
	}

	@Override
	public <S extends Plano> List<S> saveAll(Iterable<S> entities) {
				return null;
	}

	@Override
	public List<Plano> findAll() {
				return null;
	}

	@Override
	public List<Plano> findAllById(Iterable<Long> ids) {
				return null;
	}

	@Override
	public <S extends Plano> S save(S entity) {
				return null;
	}

	@Override
	public Optional<Plano> findById(Long id) {
				return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
				return false;
	}

	@Override
	public long count() {
				return 0;
	}

	@Override
	public void deleteById(Long id) {
				
	}

	@Override
	public void delete(Plano entity) {
				
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
				
	}

	@Override
	public void deleteAll(Iterable<? extends Plano> entities) {
			
	}

	@Override
	public void deleteAll() {
				
	}

	@Override
	public List<Plano> findAll(Sort sort) {
				return null;
	}

	@Override
	public Page<Plano> findAll(Pageable pageable) {
				return null;
	}

	@Override
	public <S extends Plano> Optional<S> findOne(Example<S> example) {
			return Optional.empty();
	}

	@Override
	public <S extends Plano> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
	}

	@Override
	public <S extends Plano> long count(Example<S> example) {
				return 0;
	}

	@Override
	public <S extends Plano> boolean exists(Example<S> example) {
				return false;
	}

	@Override
	public <S extends Plano, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
				return null;
	}
    
}
