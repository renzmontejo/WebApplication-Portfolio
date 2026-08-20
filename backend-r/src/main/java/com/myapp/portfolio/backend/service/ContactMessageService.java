package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.ContactMessageCreateRequest;
import com.myapp.portfolio.backend.dto.request.ContactMessageStatusRequest;
import com.myapp.portfolio.backend.dto.response.ContactMessageResponse;
import com.myapp.portfolio.backend.mapper.ContactMessageMapper;
import com.myapp.portfolio.backend.model.ContactMessage;
import com.myapp.portfolio.backend.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;

    public ContactMessageResponse create(ContactMessageCreateRequest request) {
        ContactMessage message = contactMessageMapper.toEntity(request);

        ContactMessage saved = contactMessageRepository.save(message);

        return contactMessageMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ContactMessageResponse getById(Long id) {
        ContactMessage message = contactMessageRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contact message not found with id: " + id)
                );

        return contactMessageMapper.toResponse(message);
    }

    @Transactional(readOnly = true)
    public List<ContactMessageResponse> getAll() {
        return contactMessageRepository.findAll()
                .stream()
                .map(contactMessageMapper::toResponse)
                .toList();
    }

    public ContactMessageResponse updateStatus(
            Long id,
            ContactMessageStatusRequest request
    ) {
        ContactMessage message = contactMessageRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contact message not found with id: " + id)
                );

        contactMessageMapper.updateStatus(request, message);

        return contactMessageMapper.toResponse(message);
    }

    public void delete(Long id) {
        if (!contactMessageRepository.existsById(id)) {
            throw new RuntimeException(
                    "Contact message not found with id: " + id
            );
        }

        contactMessageRepository.deleteById(id);
    }
}