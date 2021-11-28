package com.example.appgmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterGmail extends BaseAdapter {
    private Context context;
    private int layout;
    private List<AppEntity> appEntityList;

    public AdapterGmail(Context context, int layout, List<AppEntity> appEntityList) {
        this.context = context;
        this.layout = layout;
        this.appEntityList = appEntityList;
    }

    @Override
    public int getCount() {
        return appEntityList.size();
    }

    @Override
    public Object getItem(int i) {
        return appEntityList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.imageV = view.findViewById(R.id.imageApp);
            viewHolder.textName = view.findViewById(R.id.nameApp);
            viewHolder.textDes = view.findViewById(R.id.desApp);
            viewHolder.textTitle = view.findViewById(R.id.titleApp);
            viewHolder.dateSend = view.findViewById(R.id.dateSendApp);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        AppEntity appEntity = appEntityList.get(i);
        viewHolder.textName.setText(appEntity.getName());
        viewHolder.textDes.setText(appEntity.getDescription());
        viewHolder.imageV.setText(Character.toString(appEntity.getImage()));
        viewHolder.textTitle.setText(appEntity.getTitle());
        viewHolder.dateSend.setText(appEntity.getDataSend());
        return view;
    }
    public class ViewHolder {
        public TextView textName;
        public TextView textDes;
        public Button imageV;
        public TextView textTitle;
        public TextView dateSend;
    }
}
