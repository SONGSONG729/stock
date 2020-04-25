package com.song.controler;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/getData")
public class StockRequestServlet extends HttpServlet {
    StockRequest request = new StockRequest();
    StockSN StockSN = new StockSN();
    JSONObject object = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String gid = req.getParameter("gid");
        System.out.println("gid="+gid);
//        object = request.getRequest1(gid);  // 用聚合数据股票api
        object = StockSN.request(gid);  // 用新浪股票api
        System.out.println(object);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");//返回的格式必须设置为application/json
        PrintWriter out = resp.getWriter();
        out.print(object); //写入到返回结果中
        //完成，执行到这里就会返回数据给前端，前端结果为success，调用success里面的内容

    }

}
