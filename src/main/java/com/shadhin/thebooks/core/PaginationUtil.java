package com.shadhin.thebooks.core;

import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationUtil {
    public static PaginationResponse convertPageToPaginationResponse(Page page) {
        int currentPage = page.getNumber();
        int pageSize = page.getSize();
        int totalItems = (int) page.getTotalElements();
        List users = page.getContent();
        int totalPages = page.getTotalPages();
        Integer nextPage = page.hasNext() ? currentPage + 1 : null;
        Integer prevPage = page.hasPrevious() ? currentPage - 1 : null;

        return new PaginationResponse<>(currentPage, pageSize, totalItems,totalPages, users, nextPage, prevPage);
    }
}