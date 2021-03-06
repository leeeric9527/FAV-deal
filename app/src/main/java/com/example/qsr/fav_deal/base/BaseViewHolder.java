package com.example.qsr.fav_deal.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qsr.fav_deal.recycler.OnEditOrDeleteListener;
import com.example.qsr.fav_deal.recycler.OnRecyclerViewListener;
import com.example.qsr.fav_deal.utils.LogUtil;

import butterknife.ButterKnife;

/**************************************
 * FileName : BaseViewHolder
 * Author : qsr
 * Time : 2016/7/29 15:57
 * Description : ViewHolder的基类适配器（携带监听事件）
 **************************************/
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
    protected OnRecyclerViewListener onRecyclerViewListener;//声明点击事件接口
    protected Context context;//声明上下文对象
    public BaseViewHolder(Context context,OnRecyclerViewListener onRecyclerViewListener, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
        this.onRecyclerViewListener = onRecyclerViewListener;
        this.context = context;
        ButterKnife.bind(this, itemView);
        //将适配器中的接口对象传递给holder使用
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    /**
     * 用于Adapter回调
     * 数据与控件一一绑定
     * @param t 传入的数据，用于绑定到控件上
     */
    public abstract void bindData(T t);
    @Override
    public void onClick(View v) {
        if(onRecyclerViewListener!=null){
            LogUtil.MyLog_e(context,"进来了抽象holder点击事件");
            onRecyclerViewListener.onItemClick(getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(onRecyclerViewListener!=null){
            onRecyclerViewListener.onItemLongClick(v,getAdapterPosition());
        }
        return true;
    }
}
