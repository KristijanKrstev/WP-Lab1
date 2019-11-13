package mk.finki.ukim.mk.lab.web;

import eu.bitwalker.useragentutils.UserAgent;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request, response,request.getServletContext());
        this.springTemplateEngine.process("listPizzas.html",webContext, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request, response,request.getServletContext());

        HttpSession session= request.getSession();
        String clientName = request.getParameter("clientName");
        String clientAddress = request.getParameter("clientAddress");

        session.setAttribute("clientName", clientName);
        session.setAttribute("clientAddress", clientAddress);

        UserAgent uA = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        String userAgent = uA.getBrowser().getName() + " " + uA.getOperatingSystem();

        session.setAttribute("userAgent", userAgent);
        session.setAttribute("ipaddress",request.getRemoteHost());

       session.setAttribute("order", orderService.placeOrder(session.getAttribute("pizzaType").toString(),clientName,clientAddress, (long) 8));

        this.springTemplateEngine.process("confirmationInfo.html",webContext, response.getWriter());

    }

}
