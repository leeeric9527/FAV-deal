package com.example.qsr.fav_deal.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.qsr.fav_deal.base.BaseViewHolder;
import com.example.qsr.fav_deal.bean.ShowGoods;
import com.example.qsr.fav_deal.recycler.OnRecyclerViewListener;
import com.example.qsr.fav_deal.recycler.holders.FruitNormalHolder;
import com.example.qsr.fav_deal.utils.LogUtil;

import java.util.List;

/**************************************
 * FileName : com.example.qsr.fav_deal.recycler.adapter
 * Author : qsr
 * Time : 2016/7/31 0:59
 * Description : 主页水果列表适配器
 * 使其泛型为自定义ViewHolder的父类，方便传入多种类型的ViewHolder
 **************************************/
public class AllFruitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_NORMAL = 0;//表示使用的是一般的横向的一个商品
    private final int TYPE_ADVERT = 1;//表示使用的横向的一个广告栏展示
    private List<ShowGoods> goodsList;
    private ShowGoods showGoods;
    private Context context;
    private OnRecyclerViewListener onRecyclerViewListener;
    public AllFruitAdapter(Context context, List<ShowGoods> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    /**
     * 让用户有需求的时候再使用该方法
     * @param onRecyclerViewListener
     */
    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }
    @Override
    public int getItemViewType(int position) {
        //重写这个函数，让View的类型返回值按照自定义的取值走
        return goodsList.get(position).getShowType();//获取该条目的数据展示方式
    }

    /**
     * 判断View的类型，采取不同的ViewHolder的展现方式
     * @return 需要使用的ViewHolder处理
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(TYPE_NORMAL == viewType){
            return new FruitNormalHolder(context,onRecyclerViewListener,parent);
        }else if(TYPE_ADVERT == viewType) {
            //这是一个广告位---未完待续
            return null;
        }else
            return null;
    }

    /**
     * 将绑定数据的事情交回给ViewHolder去做
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder)holder).bindData(goodsList.get(position));
        LogUtil.MyLog_e(context,"进来了绑定数据地方");
        /***************如果有需要使用holder中的其他方法******************/
        if(holder instanceof FruitNormalHolder){
            //调用其中的办法: 如让某些控件的不可见
        }else if(holder instanceof FruitNormalHolder) {
            //这是一个广告位---未完待续
        }else{

        }
    }
    @Override
    public int getItemCount() {
        return goodsList.size();
    }
}
