package com.myphotoeditinglibrarys;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FontsAdapter extends ArrayAdapter<String> {

    private final LayoutInflater inflater;
    private final FontSetting fontProvider;

    public FontsAdapter(Context context, List<String> fontNames,FontSetting  fontProvider) {
        super(context, 0, fontNames);
        // save LayoutInflater for later reuse
        this.inflater = LayoutInflater.from(context);
        this.fontProvider = fontProvider;
    }

    @android.support.annotation.NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        String fontName = getItem(position);

        vh.textView.setTypeface(fontProvider.getTypeface(fontName));
        vh.textView.setText(fontName);

        return convertView;
    }

    private static class ViewHolder {

        TextView textView;

        ViewHolder(View rootView) {
            textView = (TextView) rootView.findViewById(android.R.id.text1);
        }
    }
}