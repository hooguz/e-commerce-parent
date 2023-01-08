package com.huseyinonur.pimservice.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest extends BaseDto {

    private String name;

}