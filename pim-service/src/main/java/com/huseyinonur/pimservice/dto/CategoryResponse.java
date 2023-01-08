package com.huseyinonur.pimservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse extends BaseDto {

    private Long id;
    private String name;

}
