package com.huseyinonur.pimservice.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
public class CategoryRequest {

    private String name;

}