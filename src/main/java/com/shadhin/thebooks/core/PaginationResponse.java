package com.shadhin.thebooks.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PaginationResponse<T> {
    private int page;
    private int limit;
    private int total;
    private int totalPages;
    private List<T> data;
    private Integer nextPage;
    private Integer prevPage;
}