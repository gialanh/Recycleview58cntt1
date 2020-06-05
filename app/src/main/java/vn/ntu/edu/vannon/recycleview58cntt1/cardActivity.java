package vn.ntu.edu.vannon.recycleview58cntt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.ntu.edu.vannon.controller.icartcontroller;
import vn.ntu.edu.vannon.modul.product1;

public class cardActivity<showCart> extends AppCompatActivity {
          TextView txtCart;
            Button  btnoder  , btndelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        addcard() ;

    }
    private  void addcard()
    {
             txtCart = findViewById(R.id.txtCart);
             btnoder =findViewById(R.id.btnoder) ;
             btndelete= findViewById(R.id.btnDelete) ;
             btndelete.setOnClickListener((View.OnClickListener) this);
             btnoder.setOnClickListener((View.OnClickListener) this);
           showCart() ;
    }

    private void showCart() {

        icartcontroller contronller = (icartcontroller) getApplication();
        List<product1> card = contronller.getallCart();
        StringBuilder builder = new StringBuilder();
        for (product1 p : card) {
            builder.append(p.getName()).append("\t")
                    .append(p.getPrice()).append("\t\t\t")
                    .append(p.getDesc()).append("\n");


        }
        if (builder.toString().length() > 0) {
            txtCart.setText(builder.toString());
        } else {
            txtCart.setText("chưa có măt hàng nào trong giỏ ");
        }
    }

    public void onClick(View v) {
        int id = v.getId() ;
        switch (id)

        {
            case R.id.btnoder  :
                 submit();
                 break;
            case  R.id.btnDelete :
                delete() ;
                break;
        }
    }
       private  void delete()
       {
            icartcontroller contronler = (icartcontroller)getApplication() ;
            contronler.clearcard();
            showCart();
       }
       private  void submit()
       {
           Toast.makeText(cardActivity.this,"đã submit " ,Toast.LENGTH_SHORT).show();
       }

}



