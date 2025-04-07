package org.example.project01.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.project01.model.SupplierModel;
import org.example.project01.tm.Product;
import org.example.project01.tm.Supplier;

import java.util.ArrayList;

public class ProductController {
    public TextField txt_pId;
    public TextField txt_pDes;
    public TextField txt_pUPrice;
    public ComboBox cmb_SId;
    public TableView<Product> tbl_pView;

    public void initialize() {
        tbl_pView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbl_pView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tbl_pView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        tbl_pView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("sId"));

        loadSupplierIds();
    }

    public void loadSupplierIds(){
        ArrayList<Supplier> suppliers = SupplierModel.getAllSuplliers();
        ObservableList idsList = FXCollections.observableArrayList();
        suppliers.forEach(supplier -> {
          idsList.add(supplier.getId());
        });
        cmb_SId.setItems(idsList);
    }


    public void btn_Delete(ActionEvent event) {

    }


    public void btn_Insert(ActionEvent event) {
        cmb_SId.getValue();
    }


    public void btn_Search(ActionEvent event) {

    }


    public void btn_Update(ActionEvent event) {

    }

}
