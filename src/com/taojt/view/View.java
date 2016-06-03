package com.taojt.view;

import com.taojt.action.GoddnessAction;
import com.taojt.model.Goddness;
import jdk.nashorn.internal.ir.WhileNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 * Created by taojt on 2016/6/3.
 */
public class View {

    private static final String CONTEXT="欢迎来到女神禁区：\n" +
            "下面是女神禁区的功能列表：\n" +
            "[MAIN/M]:主菜单\n" +
            "[QUERY/Q]:查看全部女神的信息\n" +
            "[GET/G]:查看某位女神的详细信息\n" +
            "[ADD/A]:添加女神信息\n" +
            "[UPDATE/U]:更新女神信息\n" +
            "[DELETE/D]:删除女神信息\n" +
            "[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" +
            "[EXIT/E]:退出女神禁区\n" +
            "[BREAK/B]:退出当前功能，返回主菜单";

    private static final String OPERATION_MAIN="MAIN";
    private static final String OPERATION_QUERY="QUERY";
    private static final String OPERATION_GET="GET";
    private static final String OPERATION_ADD="ADD";
    private static final String OPERATION_UPDATE="UPDATE";
    private static final String OPERATION_DELETE="DELETE";
    private static final String OPERATION_SEARCH="SEARCH";
    private static final String OPERATION_EXIT="EXIT";
    private static final String OPERATION_BREAK="BREAK";

    public static void main(String[] args){
        System.out.println(CONTEXT);

        Scanner scanner = new Scanner(System.in);
        Goddness goddness = new Goddness();
        GoddnessAction goddnessAction = new GoddnessAction();
        String previous = null;
        int step = 1;
        while(scanner.hasNext()){
            String in = scanner.next().toString();
//            System.out.println("您输入的值为： " + in);
            if(OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
                System.out.println("您已成功退出女神系统！");
                break;
            }else if(OPERATION_QUERY.equals(in.toUpperCase()) || OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())){
                try {
                    List<Goddness> results = goddnessAction.query();
                    for(Goddness g :results){
                        System.out.println(g.getId() + ", name: " + g.getUsername());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
             else if(OPERATION_ADD.equals(in.toUpperCase()) || OPERATION_ADD.substring(0,1).equals(in.toUpperCase()) || OPERATION_ADD.equals(previous)){
                // 新增
                previous = OPERATION_ADD;
                if(1==step){
                    System.out.println("请输入女神的 [姓名]： ");
                }else if (2==step){
                    goddness.setUsername(in);
                    System.out.println("请输入女神的 [性别] (0:男, 1:女)： ");
                }else if (3==step){
                    goddness.setSex(Integer.valueOf(in));
                    System.out.println("请输入女神的 [年龄] ： ");
                }else if (4==step){
                    goddness.setAge(Integer.valueOf(in));
                    System.out.println("请输入女神的 [生日] (格式如：yyyy-MM-dd)： ");
                }else if (5==step){
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        birthday = sf.parse(in);
                        goddness.setBirthday(birthday);
                        System.out.println("请输入女神的 [邮箱] ： ");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("您输入的格式有误，请重新输入!");
                        step = 4;
                    }
                }else if (6==step){
                    goddness.setEmail(in);
                    System.out.println("请输入女神的 [电话] ： ");
                }else if (7==step){
                    goddness.setMobile(in);
                    try {
                        goddnessAction.add(goddness);
                        System.out.println("新增女神成功！");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("新增女神失败！");
                    }
                }
                if(OPERATION_ADD.equals(previous)){
                    step++;
                }

            }else{
                System.out.println("您输入的值为： " + in);
            }

        }
    }
}
