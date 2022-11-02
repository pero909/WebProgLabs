
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BaloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "selectBalloon",urlPatterns = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BaloonService baloonService;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine,BaloonService baloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.baloonService=baloonService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext =  new WebContext(req,resp, req.getServletContext());
        springTemplateEngine.process("selectBalloonSize.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String size= req.getParameter("size");
        Order order=(Order) req.getSession().getAttribute("order");
        order.setBaloonSize(size);
        req.getSession().setAttribute("order",order);
        resp.sendRedirect("/BalloonOrder.do");
    }
}
