package com.appgate.sse_test_api.repository;

import com.appgate.sse_test_api.entity.Process;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProcessRepository extends CrudRepository<Process, Long> {

    List<Process> findByDomainChecked(String domainChecked);

}
