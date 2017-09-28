package mx.brigadas.sms.brigadassms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.brigadas.sms.brigadassms.domain.HelpRequest;

@Repository
public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

}
