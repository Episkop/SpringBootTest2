package com.example.springboottest2.serveces;
import com.example.springboottest2.model.Image;
import com.example.springboottest2.model.Product;
import com.example.springboottest2.repositories.ImageRepository;
import com.example.springboottest2.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
   private final ProductRepository productRepository;

    public List<Product> list (String name) {
        if (name != null) return productRepository.findByName(name);
        return productRepository.findAll();
}


    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3 ) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() !=0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImagesToProduct(image1);
        }
        if (file2.getSize() !=0){
            image2 = toImageEntity(file1);
            product.addImagesToProduct(image2);
        }
        if (file3.getSize() !=0){
            image3 = toImageEntity(file1);
            product.addImagesToProduct(image3);
        }
        Product productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImages().get(0).getId());
        productRepository.save(product);
    }


    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());
        image.setBytes(file.getBytes());
        return image;
    }

    public void delele(long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(long id) {
      return productRepository.findById(id).orElse(null);
    }
}
