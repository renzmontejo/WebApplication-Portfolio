package com.myapp.portfolio.backend.repository;

import com.myapp.portfolio.backend.model.MeetingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRequestRepository extends JpaRepository<MeetingRequest, Long> {
}
