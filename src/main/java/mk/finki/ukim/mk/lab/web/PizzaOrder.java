package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="order-servlet", urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request,response,request.getServletContext());
       // this.springTemplateEngine.process("listPizzas.html",webContext,response.getWriter());
        response.sendRedirect("");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request,response,request.getServletContext());
        HttpSession session=request.getSession();
        String pizza_size= request.getParameter("pizza_size");
        session.setAttribute("pizza_size", pizza_size);

        this.springTemplateEngine.process("deliveryInfo.html",webContext,response.getWriter());


    }
}
