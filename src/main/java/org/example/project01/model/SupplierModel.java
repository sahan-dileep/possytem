package org.example.project01.model;

import org.example.project01.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SupplierModel {

    public static int saveData(SupplierDTO supplierDTO){
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
            return result;

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public static int updateData(SupplierDTO supplierDTO){

        try{
            //01 create sql
            String sql = "update supplier set sname=?,address=?,tel=? where sid=?";

            //02 run the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //03 create a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","Sdg@0452265846");

            //04 create statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,supplierDTO.getName());
            preparedStatement.setString(2,supplierDTO.getAddress());
            preparedStatement.setInt(3, supplierDTO.getTel());
            preparedStatement.setString(4, supplierDTO.getId());

            //05 execute the sql
            int result = preparedStatement.executeUpdate();
            return result;

        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        return 0;
    }

    public static int deleteData(String id){
        try{
            //01 create sql
            String sql = "delete FROM supplier WHERE sid=?";

            //02 run the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //03 create a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","Sdg@0452265846");

            //04 create statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            //05 execute the sql
            int result = preparedStatement.executeUpdate();
            return result;

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public static ResultSet searchData(String id){
        try{
            //01 create sql
            String sql = "select * from supplier where sid=?";

            //02 run the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //03 create a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","Sdg@0452265846");

            //04 create statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            //05 execute the sql
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()){
                return result;
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }
}
