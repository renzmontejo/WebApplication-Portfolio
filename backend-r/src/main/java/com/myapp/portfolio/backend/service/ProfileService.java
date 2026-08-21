package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.ProfileRequest;
import com.myapp.portfolio.backend.dto.response.ProfileResponse;
import com.myapp.portfolio.backend.exception.ResourceNotFoundException;
import com.myapp.portfolio.backend.mapper.ProfileMapper;
import com.myapp.portfolio.backend.model.Profile;
import com.myapp.portfolio.backend.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponse create(ProfileRequest request) {
        Profile profile = profileMapper.toEntity(request);

        Profile saved = profileRepository.save(profile);

        return profileMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ProfileResponse getById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Profile not found with id: " + id
                        )
                );

        return profileMapper.toResponse(profile);
    }

    @Transactional(readOnly = true)
    public List<ProfileResponse> getAll() {
        return profileRepository.findAll()
                .stream()
                .map(profileMapper::toResponse)
                .toList();
    }

    public ProfileResponse update(
            Long id,
            ProfileRequest request
    ) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Profile not found with id: " + id
                        )
                );

        profileMapper.update(request, profile);

        return profileMapper.toResponse(profile);
    }

    public void delete(Long id) {
        if (!profileRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Profile not found with id: " + id
            );
        }

        profileRepository.deleteById(id);
    }
}