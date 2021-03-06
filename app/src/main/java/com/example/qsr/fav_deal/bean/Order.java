package com.example.qsr.fav_deal.bean;

import com.example.qsr.fav_deal.bmobUtil.bean.BmobOrder;
import com.google.gson.Gson;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**************************************
 * FileName : com.example.qsr.fav_deal.bean
 * Author : qsr
 * Time : 2016/7/28 20:30
 * Description : 订单
 **************************************/
public class Order extends BmobObject{
    private String o_id;//订单的唯一标识
    private String u_id;//订单所属的用户id
    private String time;//订单时间
    private Integer o_money;//订单总金额
    private String o_state = "0";//订单进度 - 0 已付款 - 1 商家已接单 -  2 已发货  - 3 交易结束
    private String o_judge;//本订单的用户评价
    private String o_note;//本订单的用户备注
    private String a_id;//地址的id
    private List<CartItem> list;//订单中的物品详情

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getO_money() {
        return o_money;
    }

    public void setO_money(Integer o_money) {
        this.o_money = o_money;
    }

    public String getO_state() {
        return o_state;
    }

    public void setO_state(String o_state) {
        this.o_state = o_state;
    }

    public String getO_judge() {
        return o_judge;
    }

    public void setO_judge(String o_judge) {
        this.o_judge = o_judge;
    }

    public String getO_note() {
        return o_note;
    }

    public void setO_note(String o_note) {
        this.o_note = o_note;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "o_id=" + o_id +
                ", u_id=" + u_id +
                ", time=" + time +
                ", o_money=" + o_money +
                ", o_state='" + o_state + '\'' +
                ", o_judge='" + o_judge + '\'' +
                ", o_note='" + o_note + '\'' +
                ", a_id=" + a_id +
                ", list=" + list +
                '}';
    }

    public Order(String o_id, String u_id, String time, Integer o_money, String o_state, String o_judge, String o_note, String a_id, List<CartItem> list) {
        this.o_id = o_id;
        this.u_id = u_id;
        this.time = time;
        this.o_money = o_money;
        this.o_state = o_state;
        this.o_judge = o_judge;
        this.o_note = o_note;
        this.a_id = a_id;
        this.list = list;
    }

    public Order() {
    }

    public BmobOrder toBmobOrder(Order order) {
        BmobOrder bmobOrder = new BmobOrder();
        bmobOrder.setU_id(order.getU_id());
        bmobOrder.setA_id(order.getA_id());
        bmobOrder.setTime(order.getTime());
        bmobOrder.setO_money(order.getO_money());
        bmobOrder.setO_state(order.getO_state());
        bmobOrder.setO_judge(order.getO_judge());
        bmobOrder.setO_note(order.getO_note());
        Gson gson = new Gson();
        bmobOrder.setGoodsDetail(gson.toJson(order.getList()));
        return bmobOrder;
    }
}
