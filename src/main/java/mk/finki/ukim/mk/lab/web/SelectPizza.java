package mk.finki.ukim.mk.lab.web;

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

@WebServlet(name = "select-pizza" , urlPatterns = "/selectPizza.do")
public class SelectPizza extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public SelectPizza(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request, response,request.getServletContext());
        this.springTemplateEngine.process("listPizzas.html", webContext, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request, response,request.getServletContext());
        HttpSession session= request.getSession();
        String pizzaType = request.getParameter("pizza");
        session.setAttribute("pizzaType", pizzaType);
        this.springTemplateEngine.process("selectPizzaSize.html",webContext, response.getWriter());

        //   response.sendRedirect("/PizzaOrder.do");
    }
}
