package com.example.expandabletextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        List<String> list = new ArrayList<>();
        list.add("23333");
        list.add("Android provides an adaptive app framework that allows you to provide unique resources for different device configurations. For example, you can create different XML layout files for different screen sizes and the system determines which layout to apply based on the current device's screen size.Android provides an adaptive app framework that allows you to provide unique resources for different device configurations. For example, you can create different XML layout files for different screen sizes and the system determines which layout to apply based on the current device's screen size.\"");
        list.add("Android provides an adaptive app framework that allows you to provide unique resources for different device configurations. For example, you can create different XML layout files for different screen sizes and the system determines which layout to apply based on the current device's screen size.\"");
        list.add("Android provides an adaptive app framework that allows you to provide unique resources for different device configurations. For example, you can create different XML layout files for different screen sizes and the system determines which layout to apply based on the current device's screen size.\"");
        list.add("Android provides an adaptive app framework that allows you to provide unique resources for different device configurations. For example, you can create different XML layout files for different screen sizes and the system determines which layout to apply based on the current device's screen size.\"");
        list.add("Android provides an adaptive app framework that allows you to provide unique resources for different device configurations. For example, you can create different XML layout files for different screen sizes and the system determines which layout to apply based on the current device's screen size.\"");

        listView.setAdapter(new MyAdapter(list));
    }

    class MyAdapter extends BaseAdapter{
        private List<String> lists;
        private SparseBooleanArray mCollapsedStatus;
        public MyAdapter(List<String> lists) {
            this.lists = lists;
            mCollapsedStatus = new SparseBooleanArray();
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.expandableTextView = (ExpandableTextView) convertView.findViewById(R.id.expand_text_view);
                viewHolder.button = (Button) convertView.findViewById(R.id.button);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.expandableTextView.setText(lists.get(position), mCollapsedStatus, position);
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"2333",Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }


    }

    private static class ViewHolder{
        ExpandableTextView expandableTextView;
        Button button;
    }


}
