package finki.ukim.mk.webapp.web.servlet;

import finki.ukim.mk.webapp.model.Exceptions.InvalidUserCredentialsException;
import finki.ukim.mk.webapp.model.User;
import finki.ukim.mk.webapp.service.AuthService;
import finki.ukim.mk.webapp.service.impl.AuthServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet",urlPatterns = "/log")
public class LoginServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final AuthService authService;

    public LoginServlet(SpringTemplateEngine springTemplateEngine, AuthService authService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authService=authService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,req.getServletContext());
        springTemplateEngine.process("login.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password= req.getParameter("password");

        User user=null;
        try {
           user= authService.login(username, password);
        }catch (InvalidUserCredentialsException ex){
            WebContext context= new WebContext(req,resp,req.getServletContext());
            context.setVariable("hasError",true);
            context.setVariable("error",ex.getMessage());
            springTemplateEngine.process("login.html",context,resp.getWriter());
        }
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("servlet/thymeleaf/category");
    }
}
