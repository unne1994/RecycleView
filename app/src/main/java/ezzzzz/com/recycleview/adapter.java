package ezzzzz.com.recycleview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//step1. 先做出adapter 建構子 可以傳入哪個context , 資料(data)
//step2. 建立holder類別 且 繼承 RecyclerView.ViewHolder  實作(alt+enter)
//step3. 到最上面屬性adpter  繼承 RecyclerView.Adapter , 且泛型自己跟step2的 (adapter.holder)
//       再實作 3種方法
//onCreateViewHolder 介紹給  holder 認識  (可以在hoder內itemView.findviewbyid元件(自己定義的物件layout))
//holder 認識完後會給 onBindViewHolder 參數1可以找到上面的元件並且給值,參數2 資料的位置
//getItemCount 資料的長度
//完成後去main new出來物件


public class adapter extends  RecyclerView.Adapter<adapter.holder> {
    public    Context contrxt;
    public ArrayList<String> data;

    //conteaxt data
    public adapter(Context contract , ArrayList<String> data) {
         this.contrxt= contract;
         this.data = data;
    }
    //view
    public class holder extends RecyclerView.ViewHolder {

        public  TextView one;
        public  TextView two;

        public holder(@NonNull View itemView) {
            super(itemView);

            one = itemView.findViewById(R.id.textView1);
            two = itemView.findViewById(R.id.textView2);
        }

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mylayout, parent, false);
        holder vh = new holder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, final int position) {

        holder.one.setText(data.get(position));
        holder.two.setText(data.get(position));

       /* //綁定一行的
       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contrxt,String .valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });*/
//       -----------------
      /* //設定特定元件

       holder.one.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(contrxt,String .valueOf(position),Toast.LENGTH_SHORT).show();
           }
       });*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
