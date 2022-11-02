
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BaloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ballonOrderServlet",urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BaloonService baloonService;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine,
                               BaloonService baloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.baloonService =baloonService ;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext= new WebContext(req,resp, req.getServletContext());

        springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        Order order= (Order) req.getSession().getAttribute("order");
        order.setClientName(clientName);
        order.setClientAdress(clientAddress);

        resp.sendRedirect("/ConfirmationInfo");
    }
}
