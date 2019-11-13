package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "pizza-servlet", urlPatterns = "")
public class ShowPizza extends HttpServlet {
    private final PizzaService pizzaService;
    private final SpringTemplateEngine springTemplateEngine;

    public ShowPizza(PizzaService pizzaService, SpringTemplateEngine springTemplateEngine) {
        this.pizzaService = pizzaService;
        this.springTemplateEngine = springTemplateEngine;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        WebContext webContext=new WebContext(request,response,request.getServletContext());
        List<Pizza> pizzas=pizzaService.getAllPizzas();
        webContext.setVariable("pizzas",pizzas);
        response.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas.html",webContext, response.getWriter());




    }



}
