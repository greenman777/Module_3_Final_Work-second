package game.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/hello")
public class HelloServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(HelloServlet.class);
    private static final String PATH = "/WEB-INF/views/play.jsp";
    private  static final String STATE_STRING = "Ты потерял память. Принять вызов НЛО?";
    private  static final String ANSWER_YES = "Принять вызов НЛО?";
    private static final String ANSWER_NO = "Отклонить вызов НЛО?";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        LOGGER.info("User Name is: " + name);
        HttpSession session = req.getSession(true);
        LOGGER.info("User`s Session iD: " + session.getId());
        session.setAttribute("name", name);
        session.setAttribute("stateString", STATE_STRING);
        LOGGER.info("User`s stateString: " + STATE_STRING);
        req.setAttribute("stateString", STATE_STRING);
        req.setAttribute("answerYes", ANSWER_YES);
        req.setAttribute("answerNo", ANSWER_NO);
        getServletContext().getRequestDispatcher(PATH).forward(req, resp);
        LOGGER.warn("request and response " + req + resp.toString());
    }
}



