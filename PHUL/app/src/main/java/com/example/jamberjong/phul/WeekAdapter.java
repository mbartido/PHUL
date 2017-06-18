package com.example.jamberjong.phul;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeekAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> dataSource;

    public WeekAdapter(Context context, ArrayList<String> items){
        mContext = context;
        dataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return dataSource.size();
    }

    @Override
    public Object getItem(int position){
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Gets the view for the row item
        View rowView = mInflater.inflate(R.layout.list_item_week, parent, false);

        // Title element
        TextView titleTextView =
                (TextView) rowView.findViewById(com.example.jamberjong.phul.R.id.week_list_header);
        // Text element
        TextView textView =
                (TextView) rowView.findViewById(R.id.week_list_text);

        // Set the text of the row
        //String week = (String) getItem(position);
        titleTextView.setText("Day " + (position+1));
        int mod = position % 4;
        if(mod == 0) {
            textView.setText("Upper Power");
        } else if (mod == 1) {
            textView.setText("Lower Power");
        } else if (mod == 2) {
            textView.setText("Upper Hypertrophy");
        } else {
            textView.setText("Lower Hypertrophy");
        //textView.setText("This is week " + position);
        }

        // Font stuff for title
        Typeface titleTypeFace =
                Typeface.createFromAsset(mContext.getAssets(), "fonts/DroidSans-Bold.ttf");
        titleTextView.setTypeface(titleTypeFace);
        // For the bottom text
        Typeface textTypeFace =
                Typeface.createFromAsset(mContext.getAssets(), "fonts/BebasNeue Regular.ttf");
        textView.setTypeface(textTypeFace);

        return rowView;
    }


}
