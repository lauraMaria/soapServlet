package ro.iquest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by laura.petrosanu on 8/13/2015.
 */
@WebServlet(name = "SOAPServlet", urlPatterns = {"/servlet/soapServlet/"})
public class SOAPServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        PrintWriter out = resp.getWriter();
        FileInputStream fis = new FileInputStream("xmlFile.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        while (true) {
            String s = br.readLine();
            if (s == null)
                break;
            out.println(s);
            out.flush();
        }
        fis.close();
    }
}
