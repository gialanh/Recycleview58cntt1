package vn.ntu.edu.vannon.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.ntu.edu.vannon.modul.product1;

public class cartcontroller  extends Application implements  icartcontroller {
    List<product1>ProductList =new ArrayList<>() ;
    List<product1> CartList = new ArrayList<>();
    public cartcontroller() {
        ProductList.add(new product1("chuối đà nha trang " ,25000 , "chuối đá ngon bổ rẻ ")) ;
        ProductList.add(new product1("sầu riêng khánh hòa " ,25000 , "chuối đá ngon bổ rẻ ")) ;
        ProductList.add(new product1("xoài cat tiên " ,25000 , "xoài giá rẻ ")) ;
        ProductList.add(new product1("chanh  " ,25000 , "chua  ")) ;
        ProductList.add(new product1("cam sành " ,25000 , "cam chất lượng ")) ;


    }

    public boolean addCart(product1 p){
        if(CartList.contains(p)){
            return false;
        }
        CartList.add(p);
        return true;
    }

    @Override
    public void clearcard() {
        CartList.clear();

    }

    public List<product1> getallCart()

    {
        return  CartList;
    }


    @Override
    public List<product1> getallProduct()

    {
        return  ProductList;
    }
}
