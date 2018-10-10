package com.wei.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.wei.cart.domain.Cart;
import com.wei.cart.domain.CartItem;
import com.wei.order.domain.Order;
import com.wei.order.domain.OrderItem;
import com.wei.order.service.OrderException;
import com.wei.order.service.OrderService;
import com.wei.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();

    public String zhiFu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取得到配置文件
        Properties props = new Properties();
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("merchantInfo.properties");
        props.load(input);

        //13+1的配置文件
        String p0_Cmd = "Buy";
        String p1_MerId = props.getProperty("p1_MerId");
        String p2_Order = request.getParameter("oid");
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        String p8_Url = props.getProperty("p8_Url");
        String p9_SAF = "";
        String pa_MP = "";
        String pd_FrpId = request.getParameter("pd_FrpId");
        String pr_NeedResponse = "1";

        //计算hmac
        String keyValues = props.getProperty("keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValues);


        //连接易宝网址和13+1参数
        StringBuilder url = new StringBuilder(props.getProperty("url"));
        url.append("?p0_Cmd=").append(p0_Cmd);
        url.append("&p1_MerId=").append(p1_MerId);
        url.append("&p2_Order=").append(p2_Order);
        url.append("&p3_Amt=").append(p3_Amt);
        url.append("&p4_Cur=").append(p4_Cur);
        url.append("&p5_Pid=").append(p5_Pid);
        url.append("&p6_Pcat=").append(p6_Pcat);
        url.append("&p7_Pdesc=").append(p7_Pdesc);
        url.append("&p8_Url=").append(p8_Url);
        url.append("&p9_SAF=").append(p9_SAF);
        url.append("&pa_MP=").append(pa_MP);
        url.append("&pd_FrpId=").append(pd_FrpId);
        url.append("&pr_NeedResponse=").append(pr_NeedResponse);
        url.append("&hmac=").append(hmac);

        System.out.println(url.toString());

        response.sendRedirect(url.toString());


        return null;
    }

    public String back(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到11+1参数
        String  p1_MerId = request.getParameter("p1_MerId");
        String  r0_Cmd = request.getParameter("r0_Cmd");
        String  r1_Code = request.getParameter("r1_Code");
        String  r2_TrxId = request.getParameter("r2_TrxId");
        String  r3_Amt = request.getParameter("r3_Amt");
        String  r4_Cur = request.getParameter("r4_Cur");
        String  r5_Pid = request.getParameter("r5_Pid");
        String  r6_Order = request.getParameter("r6_Order");
        String  r7_Uid = request.getParameter("r7_Uid");
        String  r8_MP = request.getParameter("r8_MP");
        String  r9_BType = request.getParameter("r9_BType");

        String hmac = request.getParameter("hmac");

        //校验易宝

        //获取得到配置文件
        Properties props = new Properties();
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("merchantInfo.properties");
        props.load(input);
        String keyValue = props.getProperty("keyValue");

        boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);


        //如果校验失败
        if (!b){
            request.setAttribute("msg", "你不是一个好东西，再来我就报警了！");
            return "f:/jsps/msg.jsp";
        }

        //获取状态订单，确认是否修改订单状态，以及添加积分等业务操作
        orderService.zhiFu(r6_Order);

        /**
         * 判断当前回调方式
         * 如果点对点，需要回馈一个success
         */

        if (r9_BType.equals("2")){
            response.getWriter().print("success");
        }

        request.setAttribute("msg", "支付成功，等待卖家发货哦！");
        return "f:/jsps/msg.jsp";
    }


    /**
     * 确认收货
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String oid = request.getParameter("oid");
        try {
            orderService.cofirm(oid);
            request.setAttribute("msg", "恭喜交易成功");
        } catch (OrderException e) {
            //如果出错的话我们就输出错误信息
            request.setAttribute("msg", e.getMessage());
        }

        return "f:/jsps/msg.jsp";
    }

    /**
     * 加载订单
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("order", orderService.load(request.getParameter("oid")));

        return "f:/jsps/order/desc.jsp";

    }

    /**
     * 我的订单
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("session_user");
        List<Order> orderList = orderService.myOrder(user.getUid());

        request.setAttribute("orderList", orderList);


        return "f:/jsps/order/list.jsp";
    }


    /**
     * 添加订单
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //从session中得到cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");


        //使用cart生成Order对象

        //创建Order对象设置属性
        Order order = new Order();//创建Order来设置属性
        order.setOid(CommonUtils.uuid());//设置编号
        order.setOrdertime(new Date());//设置下单时间
        order.setState(1);//是指订单状态，1为未付款
        User user = (User) request.getSession().getAttribute("session_user");
        order.setOwner(user);//设置下单人
        order.setTotal(cart.getTotal());//设置订单合计
        //创建订单条目集合
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();

        //遍历循环Cart中的所有CartItem,使用每一个CartItem对象创建OrderItem对象，并添加到集合中
        for (CartItem cartItem : cart.getCartItems()) {

            //创建订单条目类
            OrderItem oi = new OrderItem();

            //设置订单条目类
            oi.setIid(CommonUtils.uuid());
            oi.setCount(cartItem.getCount());
            oi.setBook(cartItem.getBook());
            oi.setOrder(order);
            oi.setSubtotal(cartItem.getSubtotal());

            //将订单条目添加到了数据
            orderItemList.add(oi);

        }
        //将所有的订单条目添加到几何中
        order.setOrderItemList(orderItemList);

        //清空购物车,在提交订单之后我们就清空了这个购物车
        cart.clear();

        //调用service方法添加订单条目
        orderService.add(order);

        //保存Order到request域中转发到/jsps/order/desc.jsp
        request.setAttribute("order", order);

        return "f:/jsps/order/desc.jsp";

    }
}
