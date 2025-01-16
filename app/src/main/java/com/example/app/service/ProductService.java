                                                            package com.example.app.service;

                                                            import com.example.app.model.Product;
                                                            import com.example.app.repo.ProductRecordRepo;
                                                            import com.example.app.repo.ProductRepo;
                                                            import org.springframework.beans.factory.annotation.Autowired;
                                                            import org.springframework.stereotype.Service;
                                                            import org.springframework.transaction.annotation.Transactional;

                                                            import java.util.ArrayList;
                                                            import java.util.Arrays;
                                                            import java.util.List;
                                                            @Service
                                                            public class ProductService {
                                                                @Autowired
                                                                ProductRepo repo;
                                                                @Autowired
                                                                ProductRecordService productRecordService;
                                                              public List<Product> getProducts(){
                                                                  return repo.findAll();

                                                              }

                                                                public Product getProductById(int prodId) {
                                                                  return repo.findById(prodId).orElse(new Product());
                                                                }

                                                            @Transactional
                                                             public void addProduct(Product prod){
                                                                  repo.save(prod);

                                                                  //simulate exception to test transaction rollback
                                                                  if(prod.getPrice()<0)
                                                                      throw new IllegalArgumentException("Price can't be -ve");

                                                                productRecordService.logAction(prod.getProdId(), "Added",prod.getProdName(),prod.getPrice());

                                                            }

                                                            @Transactional
                                                                public void updateProduct(Product prod) {
                                                                  Product existingProd= repo.findById(prod.getProdId())
                                                                                  .orElseThrow(()-> new RuntimeException("Product not Found"));

                                                                  existingProd.setProdName(prod.getProdName());
                                                                  existingProd.setPrice(prod.getPrice());
                                                                  repo.save(existingProd);

                                                                  //to test rollback
                                                                  if(prod.getProdName().equals("Error")){
                                                                      throw new RuntimeException("Simulated exception during update");
                                                                  }
                                                                productRecordService.logAction(prod.getProdId(), "Updated", prod.getProdName(), prod.getPrice());

                                                            }

//                                                            @Transactional
                                                                public void deleteProduct(int prodId) {
                                                                  Product prod= repo.findById(prodId)
                                                                                  .orElseThrow(()->new RuntimeException("Product not Found"));
                                                                    repo.deleteById(prodId);
                                                                    if(prodId==0)
                                                                        throw new RuntimeException("Simulated exception during delete");
                                                                    productRecordService.logAction(prodId, "Deleted", prod.getProdName(), prod.getPrice());

                                                                }
                                                            }
