package org.example.pharmashop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PharmaDto {
    private String name;
    private String description;
    private Integer price;
    private String picture;
}