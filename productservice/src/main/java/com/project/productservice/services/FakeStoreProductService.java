package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;

import com.project.productservice.models.Category;
import com.project.productservice.models.Product;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class FakeStoreProductService implements ProductService {
  private  RestTemplate restTemplate;
  public FakeStoreProductService(RestTemplate restTemplate)
  {
      this.restTemplate=restTemplate;
  }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject( "https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

              Product product= new Product();
              product.setId(fakeStoreProductDto.getId());
              product.setTitle(fakeStoreProductDto.getTitle());
              product.setDescription(fakeStoreProductDto.getDescription());
              product.setImageURl(fakeStoreProductDto.getImage());
              Category category=new Category();
              category.setTitle(String.valueOf(fakeStoreProductDto.getCategory()));
              product.setCategory(category);
              return  product;
  }

   /* @Override
    public Product getSingleProduct(long id) {
        RestTemplate restTemplate =new RestTemplate();

        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject
                (" https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);


        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageURl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(String.valueOf(fakeStoreProductDto.getCategory()));
        product.setCategory(category);

        return product;

    }

    */
}
