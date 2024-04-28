package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.Product;
import com.example.Best.Buy.repository.CategoryRepository;
import com.example.Best.Buy.repository.VendorRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class ExcelUploadImplService {
    @Autowired
    static
    CategoryRepository categoryRepository;
    @Autowired
    static
    VendorRepository vendorRepository;


    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Product> getProductDataFromExcel(InputStream inputStream){
        List<Product> productsList=new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet=workbook.getSheet("product");

            int rowIndex=0;
            for (Row row:sheet) {
                if (rowIndex==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator=row.iterator();
                int cellIndex=0;
                Product product=new Product();
                while (cellIterator.hasNext()){
                    Cell cell= cellIterator.next();
                    switch (cellIndex){
                        case 0: product.setId((long) cell.getNumericCellValue());
                        case 1: product.setCreatedAt(LocalDate.parse(cell.getStringCellValue()));
                        case 2: product.setName(cell.getStringCellValue());
                        case 3: product.setPrice((long) cell.getNumericCellValue());
                        case 4: long categoryId = (long) cell.getNumericCellValue();
                            product.setCategory(categoryRepository.findById(categoryId).orElse(null));
                        case 5: long vendorId = (long) cell.getNumericCellValue();
                            product.setVendor(vendorRepository.findById(vendorId).orElse(null));
                        default:{

                        }
                    }
                    cellIndex++;
                }
                productsList.add(product);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productsList;

    }

}
