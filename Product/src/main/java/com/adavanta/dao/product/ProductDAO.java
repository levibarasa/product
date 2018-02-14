/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adavanta.dao.product;
import com.atvanta.util.Databases;
import com.atvanta.util.*;
import com.atvanta.model.*;

import java.util.List;
import com.advanta.dao.model.*; 
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Levi
 */
public class ProductDAO {
    OperationsDal ops;

    public ProductDAO() {
        ops = OperationsDalImpl.getInstance(Databases.PRODUCTS);
    }
    public  boolean deleteProduct(ProductModel productModel ) {
        return ops.delete(productModel);
    }
     public  void createProduct(ProductModel productModel) {
         Product pr = new Product();  
         pr.setProductImage(productModel.getProductImage());
         pr.setDescription(productModel.getDescription());
         pr.setPrice(productModel.getPrice());
         pr.setProductImage(productModel.getProductImage());
         ops.save(pr);
     }
     public  void updateProduct(ProductModel productModel) {
         Product pr = new Product();  
         pr.setProductId(productModel.getProductId());
         pr.setProductImage(productModel.getProductImage());
         pr.setDescription(productModel.getDescription());
         pr.setPrice(productModel.getPrice());
         pr.setProductImage(productModel.getProductImage());
         ops.save(pr);
     }
      
        public ArrayList<ProductModel> getAllProducts() {
        ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
        CoreQuery coreQuery = new CoreQuery("from Product", true); 
        List prodMaster = ops.fetch(coreQuery);
        for (Object prObject : prodMaster) {
            Product prMaster = (Product) prObject;
            ProductModel productModel = new ProductModel();
       productModel.setDescription(prMaster.getDescription());
       productModel.setPrice(prMaster.getPrice());
       productModel.setProductId(prMaster.getProductId());
       productModel.setProductImage(prMaster.getProductImage());
       productModel.setProductName(prMaster.getProductName());
       productList.add(productModel);
        } 
        return productList;
        }
        public ArrayList<ProductModel> getProductByID(int prodId) {
        ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
        CoreQuery coreQuery = new CoreQuery("from Product where productId =:productId", true);
        coreQuery.addParam("productId", prodId);
        List prodMaster = ops.fetch(coreQuery);
        for (Object prObject : prodMaster) {
            Product prMaster = (Product) prObject;
            ProductModel productModel = new ProductModel();
       productModel.setDescription(prMaster.getDescription());
       productModel.setPrice(prMaster.getPrice());
       productModel.setProductId(prMaster.getProductId());
       productModel.setProductImage(prMaster.getProductImage());
       productModel.setProductName(prMaster.getProductName());
       productList.add(productModel);
        } 
        return productList;
        }
        public String byteToImage(String prod ,byte[] imageInByte){
         String imagepath ="c:/images/"+prod+".jpg";
            try { 
             BufferedImage originalImage = ImageIO.read(new File(
                        imagepath));
    // convert BufferedImage to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        baos.flush();
        imageInByte = baos.toByteArray();
        baos.close();
    // convert byte array back to BufferedImage
        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        ImageIO.write(bImageFromConvert, "jpg", new File(
                        imagepath));
           } catch (IOException e) {
        System.out.println(e.getMessage());
		}
        return imagepath; 
        }
}
