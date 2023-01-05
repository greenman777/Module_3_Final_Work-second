package game.servlets;

import game.mechanica.GameCount;
import game.mechanica.GameLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(value = "/play")
public class PlayServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(PlayServlet.class);
    private static final String PATH = "/WEB-INF/views/play.jsp";
    private static final String FINISH_PATH = "/WEB-INF/views/finish.jsp";
    private static final String VICTORY = "Победа!";
    GameLogic answerLogic = new GameLogic();
    GameCount game = new GameCount();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        answerLogic.addAnswer();
        HttpSession session = req.getSession();
        LOGGER.info("User`s Session iD: " + session.getId());
        String stateString = (String) session.getAttribute("stateString");
        String name = (String) session.getAttribute("name");
        LOGGER.info("User Name is: " + name);
        int gameCount;
        if (game.getThisUser(name)) {
            gameCount = game.getGameCount(name);
        } else {
            game.addUser(name);
            gameCount = 0;
        }
        String stateString1;
        String answerYes1 = "";
        String answerNo1 = "";
        ServletContext servletContext = getServletContext();

        boolean choice = Boolean.parseBoolean(req.getParameter("choice"));
        LOGGER.info("User`s choice: " + choice);
        if (choice) {
            stateString1 = answerLogic.answer(stateString).get(0);
            LOGGER.info("User`s stateString: " + stateString1);
            if (stateString1.endsWith(VICTORY)) {
                gameCount++;
                LOGGER.info("User`s number of game: " + gameCount);
                game.setGameCount(name, gameCount);
                req.setAttribute("stateString", stateString1);
                session.setAttribute("gameCount", gameCount);
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(FINISH_PATH);
                requestDispatcher.forward(req, resp);
            }
            answerYes1 = answerLogic.answer(stateString).get(1);
            answerNo1 = answerLogic.answer(stateString).get(2);
        } else {
            gameCount++;
            LOGGER.info("User`s number of game: " + gameCount);
            game.setGameCount(name, gameCount);
            session.setAttribute("gameCount", gameCount);
            stateString1 = answerLogic.answer(stateString).get(3);
            LOGGER.info("User`s stateString: " + stateString1);
            req.setAttribute("stateString", stateString1);
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(FINISH_PATH);
            requestDispatcher.forward(req, resp);
        }


        req.setAttribute("stateString", stateString1);
        session.setAttribute("stateString", stateString1);
        req.setAttribute("answerYes", answerYes1);
        req.setAttribute("answerNo", answerNo1);


        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(PATH);
        requestDispatcher.forward(req, resp);
        LOGGER.warn("request and response  " + req + resp.toString());
    }
}

