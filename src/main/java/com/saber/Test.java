package com.saber;

import com.google.gson.GsonBuilder;
import com.saber.websocket.WebsocketHandler;
import org.apache.log4j.Logger;
import org.springframework.web.socket.TextMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Test extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected static final Logger logger = Logger.getLogger(Test.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        try {
            WebsocketHandler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson("·ÃÎÊtest½Ó¿Ú\\n")));
            logger.warn("=========test=========");
            System.out.println("syso ================test==============");
            out.println("=====================test==========================");

            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
