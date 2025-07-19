package com.anhcuong.spring_ai.dto;

public record ExpenseInfo (
        String category,
        String itemName,
        Double amount
){
}
