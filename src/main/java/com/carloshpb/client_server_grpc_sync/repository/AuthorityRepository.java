package com.carloshpb.client_server_grpc_sync.repository;

import com.carloshpb.client_server_grpc_sync.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
