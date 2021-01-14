package cn.ylarod.devtools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.ylarod.devtools.R;
import cn.ylarod.devtools.entity.KeyValuePair;

public class KeyValuePairAdapter extends ArrayAdapter<KeyValuePair> {
    private ArrayList<KeyValuePair> keyValuePairList;
    public KeyValuePairAdapter(Context context, ArrayList<KeyValuePair> keyValuePairList) {
        super(context, R.layout.key_value_pair_row, keyValuePairList);
        this.keyValuePairList = keyValuePairList;
    }

    @Override
    public View getView(int position,  View convertView,ViewGroup parent) {
        KeyValuePair keyValuePair = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.key_value_pair_row,null);
            viewHolder = new ViewHolder();
            viewHolder.text1 = convertView.findViewById(R.id.key_value_pair_row_key);
            viewHolder.text2 = convertView.findViewById(R.id.key_value_pair_row_value);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text1.setText(keyValuePair.getKey());
        viewHolder.text2.setText(keyValuePair.getValue());

        return convertView;
    }

    class ViewHolder{
        TextView text1;
        TextView text2;
    }
}
