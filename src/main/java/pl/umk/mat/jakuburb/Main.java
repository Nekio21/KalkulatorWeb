package pl.umk.mat.jakuburb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends HttpServlet{

    private Kalkulator kalkulator;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answear = req.getParameter("kalk");

        if (answear == null || answear.isEmpty()) {
            answear = "hmmmmm";
        }

        answear = answear.trim();

        Ulamek wynik = null;
        
        try {
            kalkulator = new Kalkulator(answear);

            wynik = kalkulator.wynik();

        } catch (Exception e) {
            wynik = null;
        }

        if(wynik != null) {
            req.setAttribute("licznik", wynik.getLicznik());
            req.setAttribute("mianownik", wynik.getMianownik());
            getServletContext().getRequestDispatcher("/wynik1.jsp").forward(req, resp);
        }else{
            getServletContext().getRequestDispatcher("/wynik2.jsp").forward(req, resp);
        }


    }


}
