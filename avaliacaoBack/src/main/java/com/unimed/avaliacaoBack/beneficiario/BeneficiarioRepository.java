package com.unimed.avaliacaoBack.beneficiario;

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
public class BeneficiarioRepository implements BeneficiarioInterface {

	@Override
	public void flush() {
			
	}

	@Override
	public <S extends Beneficiario> S saveAndFlush(S entity) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> List<S> saveAllAndFlush(Iterable<S> entities) {	
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Beneficiario> entities) {	
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {	
		
	}

	@Override
	public void deleteAllInBatch() {	
		
	}

	@Override
	public Beneficiario getOne(Long id) {	
		return null;
	}

	@Override
	public Beneficiario getById(Long id) {	
		return null;
	}

	@Override
	public Beneficiario getReferenceById(Long id) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> List<S> findAll(Example<S> example) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> List<S> findAll(Example<S> example, Sort sort) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> List<S> saveAll(Iterable<S> entities) {	
		return null;
	}

	@Override
	public List<Beneficiario> findAll() {	
		return null;
	}

	@Override
	public List<Beneficiario> findAllById(Iterable<Long> ids) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> S save(S entity) {
		return null;
	}

	@Override
	public Optional<Beneficiario> findById(Long id) {
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
	public void delete(Beneficiario entity) {	
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {	
		
	}

	@Override
	public void deleteAll(Iterable<? extends Beneficiario> entities) {	
		
	}

	@Override
	public void deleteAll() {	
		
	}

	@Override
	public List<Beneficiario> findAll(Sort sort) {	
		return null;
	}

	@Override
	public Page<Beneficiario> findAll(Pageable pageable) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> Optional<S> findOne(Example<S> example) {	
		return Optional.empty();
	}

	@Override
	public <S extends Beneficiario> Page<S> findAll(Example<S> example, Pageable pageable) {	
		return null;
	}

	@Override
	public <S extends Beneficiario> long count(Example<S> example) {	
		return 0;
	}

	@Override
	public <S extends Beneficiario> boolean exists(Example<S> example) {	
		return false;
	}

	@Override
	public <S extends Beneficiario, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
	
		return null;
	}
	
}
