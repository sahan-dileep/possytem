package org.example.project01.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.project01.dto.SupplierDTO;
import org.example.project01.model.SupplierModel;
import org.example.project01.tm.Supplier;

import java.sql.*;
import java.util.ArrayList;

public class SupplierController {

    public TextField txt_id;
    public TextField txt_name;
    public TextField txt_address;
    public TextField txt_tel;
    public TableView<Supplier> tbl_view;

    public void initialize() {
        tbl_view.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbl_view.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_view.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tbl_view.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("tel"));

        ArrayList<Supplier> List = getAllSuplliers();

        tbl_view.setItems(FXCollections.observableArrayList(List));;

    }

    public void btn_Add(ActionEvent actionEvent) {

        String id = txt_id.getText();
        String name = txt_name.getText();
        String address = txt_address.getText();
        int tel = Integer.parseInt(txt_tel.getText());

        SupplierDTO supplierDTO  = new SupplierDTO(id, name, address, tel);

        int result = SupplierModel.saveData(supplierDTO);

        if(result > 0) {
            System.out.println("Added Successfully");
            initialize();
        }else{
            System.out.println("Not Added Successfully");
        }

    }

    public void btn_Update(ActionEvent actionEvent) {
        String id = txt_id.getText();
        String name = txt_name.getText();
        String address = txt_address.getText();
        int tel = Integer.parseInt(txt_tel.getText());

        SupplierDTO supplierDTO  = new SupplierDTO(id, name, address, tel);

        int result = SupplierModel.updateData(supplierDTO);

        if(result > 0) {
            System.out.println("Update Successfully");
            initialize();
        }else{
            System.out.println("Not Update Successfully");
        }
    }

    public void btn_Delete(ActionEvent actionEvent) {

        String id = txt_id.getText();


        int result = SupplierModel.deleteData(id);

        if(result > 0) {
            System.out.println("Delete Successfully");
            initialize();
        }else{
            System.out.println("Not Delete Successfully");
        }
    }

    public void btn_Search(ActionEvent actionEvent) throws SQLException {
        String id = txt_id.getText();

        ResultSet result = SupplierModel.searchData(id);

        if(result.next()) {
            txt_name.setText(result.getString("sname"));
            txt_address.setText(result.getString("address"));
            txt_id.setText(result.getString("sid"));
            txt_tel.setText(result.getString("tel"));
        }else{
            System.out.println("Result Not Found");
        }



    }

    public ArrayList<Supplier> getAllSuplliers(){
        try{
            //01 create sql
            String sql = "select * from supplier";

            //02 run the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //03 create a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system","root","Sdg@0452265846");

            //04 create statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //05 execute the sql
            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Supplier> suppliers = new ArrayList<>();

            while(result.next()){

                suppliers.add(new Supplier(result.getString("sid"),result.getString("sname"),result.getString("address"),
                        String.valueOf(result.getString("tel"))));
            }

            return suppliers;

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }
}