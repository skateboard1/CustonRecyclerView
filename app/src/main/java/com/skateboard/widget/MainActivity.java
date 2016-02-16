package com.skateboard.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CustomRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (CustomRecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addFootView(R.layout.head_and_foot_layout);
        recyclerView.addHeadView(R.layout.head_and_foot_layout);
        recyclerView.setAdapter(new MyAdapter());
    }

  private class MyAdapter extends RecyclerView.Adapter<MyHolder>
  {

      @Override
      public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View view=null;
          view= LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout,parent,false);
          MyHolder holder=new MyHolder(view);
          return holder;
      }

      @Override
      public void onBindViewHolder(MyHolder holder, int position) {
              holder.text.setText("233");
              holder.text.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      recyclerView.removeHeadView();
                  }
              });
      }

      @Override
      public int getItemCount() {
          return 150;
      }
  }

    private class MyHolder extends RecyclerView.ViewHolder
    {
        TextView text;

        public MyHolder(View itemView) {
            super(itemView);
            text= (TextView) itemView.findViewById(R.id.text);
        }
    }

}
