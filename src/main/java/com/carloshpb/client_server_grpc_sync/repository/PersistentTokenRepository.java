package com.carloshpb.client_server_grpc_sync.repository;

import com.carloshpb.client_server_grpc_sync.domain.PersistentToken;
import com.carloshpb.client_server_grpc_sync.domain.User;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link PersistentToken} entity.
 */
public interface PersistentTokenRepository extends JpaRepository<PersistentToken, String> {

    List<PersistentToken> findByUser(User user);

    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);

}
