package org.example.project01.model;

import org.example.project01.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SupplierModel {

    public static void saveData(SupplierDTO supplierDTO){
        try{
            //01 create sql
            String sql = "insert into supplier values(?,?,?,?)";

            //02 run the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //03 create a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","Sdg@0452265846");

            //04 create statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supplierDTO.getId());
            preparedStatement.setString(2, supplierDTO.getName());
            preparedStatement.setString(3, supplierDTO.getAddress());
            preparedStatement.setInt(4, supplierDTO.getTel());

            //05 execute the sql
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("Added Successfully");
            }else{
                System.out.println("Not Added Successfully");
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
