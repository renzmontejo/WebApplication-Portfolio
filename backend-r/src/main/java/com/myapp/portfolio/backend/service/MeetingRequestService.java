package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.MeetingRequestCreateRequest;
import com.myapp.portfolio.backend.dto.request.MeetingRequestStatusRequest;
import com.myapp.portfolio.backend.dto.response.MeetingRequestResponse;
import com.myapp.portfolio.backend.exception.ResourceNotFoundException;
import com.myapp.portfolio.backend.mapper.MeetingRequestMapper;
import com.myapp.portfolio.backend.model.MeetingRequest;
import com.myapp.portfolio.backend.repository.MeetingRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MeetingRequestService {

    private final MeetingRequestRepository meetingRequestRepository;
    private final MeetingRequestMapper meetingRequestMapper;

    public MeetingRequestResponse create(
            MeetingRequestCreateRequest request
    ) {
        MeetingRequest meetingRequest =
                meetingRequestMapper.toEntity(request);

        MeetingRequest saved =
                meetingRequestRepository.save(meetingRequest);

        return meetingRequestMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public MeetingRequestResponse getById(Long id) {
        MeetingRequest meetingRequest =
                meetingRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Meeting request not found with id: " + id
                                )
                        );

        return meetingRequestMapper.toResponse(meetingRequest);
    }

    @Transactional(readOnly = true)
    public List<MeetingRequestResponse> getAll() {
        return meetingRequestRepository.findAll()
                .stream()
                .map(meetingRequestMapper::toResponse)
                .toList();
    }

    public MeetingRequestResponse updateStatus(
            Long id,
            MeetingRequestStatusRequest request
    ) {
        MeetingRequest meetingRequest =
                meetingRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Meeting request not found with id: " + id
                                )
                        );

        meetingRequestMapper.updateStatus(
                request,
                meetingRequest
        );

        return meetingRequestMapper.toResponse(meetingRequest);
    }

    public void delete(Long id) {
        if (!meetingRequestRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Meeting request not found with id: " + id
            );
        }

        meetingRequestRepository.deleteById(id);
    }
}