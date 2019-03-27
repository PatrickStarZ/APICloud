package com.example.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.info.ContactInfo;
import com.example.apitest.R;

import java.util.List;

import static com.example.info.ContactInfo.EMAIL_PREFIX;
import static com.example.info.ContactInfo.NAME_PREFIX;
import static com.example.info.ContactInfo.SURNAME_PREFIX;

public class RecyclerViewAdapte extends RecyclerView.Adapter<RecyclerViewAdapte.ContactViewHolder> {

    /*数据来源*/
    private List<ContactInfo> contactInfoList;

    /*构造器*/
    public RecyclerViewAdapte(List<ContactInfo> contactInfoList) {
        this.contactInfoList = contactInfoList;
    }

    /*onCreateViewHolder()方法 返回我们自定义的 ContactViewHolder对象*/
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_cardview_main,viewGroup,false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        /*contactInfoList中包含的都是ContactInfo类的对象*/
        /*通过其get()方法可以获得其中的对象*/
        ContactInfo ci = contactInfoList.get(i);

        /*将viewholder中hold住的各个view与数据源进行绑定(bind)*/
        contactViewHolder.modulename_one.setText(NAME_PREFIX + ci.name);
        contactViewHolder.modulename_two.setText(SURNAME_PREFIX+ci.surname);
        contactViewHolder.describe.setText(EMAIL_PREFIX+ci.email);
        contactViewHolder.project_leader_name.setText(ci.surname+ "" + ci.name);
    }

    /*此方法返回列表项的数目*/
    @Override
    public int getItemCount() {
        return contactInfoList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        //create the viewHolder class
        protected TextView modulename_one;
        protected TextView modulename_two;
        protected TextView describe;
        protected TextView project_leader_name;

        public ContactViewHolder(View itemView) {
            super(itemView);
            modulename_one = itemView.findViewById(R.id.module_one);
            modulename_two = itemView.findViewById(R.id.module_two);
            describe = itemView.findViewById(R.id.describe);
            project_leader_name = itemView.findViewById(R.id.project_leader);
        }
    }
}
