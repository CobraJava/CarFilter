package com.shop.electronic.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.springframework.data.domain.PageRequest.*;

@Getter
@Setter
public class PaginationRequest {
    private Sort.Direction direction = Sort.Direction.ASC;
    private String fieldName = "id";
    private Integer page = 0;
    private Integer size = 20;

    public Pageable toPageable() {
        return of(page, size, direction, fieldName);
    }
}