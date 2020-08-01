package com.rcfotografia.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcfotografia.core.entity.Album;
import com.rcfotografia.core.exception.NotFoundException;
import com.rcfotografia.core.repository.AlbumRepository;

@Service
public class AlbumService {

	private @Autowired AlbumRepository repository;

    public List<Album> findAll() {
        return repository.findAll();
    }
    
    public Optional<Album> findByIdQuitely(Long id) {
        return repository.findById(id);
    }

    public Album findById(Long id) {
        return findByIdQuitely(id).orElseThrow(NotFoundException::new);
    }

    public Album save(Album album) {
        return repository.save(album);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }


}
