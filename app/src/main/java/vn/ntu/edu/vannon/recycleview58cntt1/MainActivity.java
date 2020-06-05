package vn.ntu.edu.vannon.recycleview58cntt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.ntu.edu.vannon.controller.icartcontroller;
import vn.ntu.edu.vannon.modul.product1;

public class MainActivity extends AppCompatActivity {
       RecyclerView mMathang;
       Adapter adapter ;
       List<product1> ListProduct ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
    }
     private void addView()
    {
            mMathang =findViewById(R.id.rvmathang) ;
            mMathang.setLayoutManager(new LinearLayoutManager(this));
            icartcontroller contronller =(icartcontroller)getApplication();
            ListProduct=contronller.getallProduct() ;
            adapter = new Adapter(ListProduct);
            mMathang.setAdapter(adapter);
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtname, txtprice, txtdesc;
        ImageView imvAddTocart;
        product1 p;


        public ProductViewHolder(View itemView) {
            super(itemView);
            txtname = this.itemView.findViewById(R.id.txtnamesp);
            txtdesc = this.itemView.findViewById(R.id.txtdesc);
            txtprice = this.itemView.findViewById(R.id.txtprice);
            imvAddTocart = this.itemView.findViewById(R.id.imageView);
            imvAddTocart.setOnClickListener(this);

        }

        public void bind(product1 p) {
            this.p = p;
            txtname.setText(p.getName());
            txtprice.setText(new Integer(p.getPrice()).toString());
            txtdesc.setText(p.getDesc());
        }


        @Override
        public void onClick(View v) {
            icartcontroller controller = (icartcontroller) getApplication();
            if(controller.addCart(p)){
                Toast.makeText(MainActivity.this, "Đã thêm " + p.getName() + "vào giỏ hàng", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, p.getName() + "đã có trong giỏ hàng", Toast.LENGTH_SHORT).show();
            }
        }
    }
  //  private  class  Adapter extends RecyclerView.Adapter <ProductViewHolder>
    private class Adapter extends RecyclerView.Adapter<ProductViewHolder>
    {
        List<product1> productlist ;
        public Adapter(List<product1>productList)

        {
        this.productlist=productList ;
    }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater  = getLayoutInflater() ;
            View view = inflater.inflate(R.layout.product,parent,false) ;
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(productlist.get(position));
        }


        @Override
        public int getItemCount()
        {
            return productlist.size();
        }

    }
  //  MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //////////////// Sự kiên khi click vào item trên MENU
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.exit:
                finish();
                break;
            case R.id.card:
                showCart();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    ///////////////// Chuyển sang Activity Cart
    private void showCart(){
        Intent intent = new Intent(this, cardActivity.class);
        startActivity(intent);
    }

}
