package com.kot.dish.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kot.dish.domain.LabelEntity;
import com.kot.dish.repository.LabelRepository;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public List<LabelEntity> getAll() {
        Page<LabelEntity> page =  labelRepository.findAll(Pageable.unpaged());
        return page.getContent();
    }
}
