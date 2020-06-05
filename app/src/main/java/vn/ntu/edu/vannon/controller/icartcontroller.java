package vn.ntu.edu.vannon.controller;

import java.util.List;

import vn.ntu.edu.vannon.modul.product1;

public interface icartcontroller
{

     public List<product1> getallProduct();
     public List<product1> getallCart();
     public boolean addCart(product1 p);
     public void clearcard () ;
}
