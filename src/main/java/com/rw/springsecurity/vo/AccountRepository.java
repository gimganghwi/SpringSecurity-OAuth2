package com.rw.springsecurity.vo;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByPrincipal(String principal);
}
