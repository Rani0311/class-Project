package com.project.productservice.dtos;

import com.project.productservice.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private  String title;
    private  double price;
    private Category category;
    private  String  description;
    private  String image;

}
