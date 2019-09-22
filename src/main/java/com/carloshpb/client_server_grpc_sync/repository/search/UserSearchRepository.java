package com.carloshpb.client_server_grpc_sync.repository.search;

import com.carloshpb.client_server_grpc_sync.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {
}
