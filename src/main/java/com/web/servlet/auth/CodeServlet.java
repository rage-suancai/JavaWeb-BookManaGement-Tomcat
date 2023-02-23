package com.web.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.Random;

/**
 * @author YXS
 * @PackageName: com.web.servlet.auth
 * @ClassName: CodeServlet
 * @Desription:
 * @date 2023/2/17 13:03
 */
@WebServlet("/code")
public class CodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect(0, 0, 100, 30);

        for (int i = 0; i < 8; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }

        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

        String number = getNumber(5);
        req.getSession().setAttribute("QR_code", number);
        g.setFont(new Font(null, Font.ITALIC + Font.BOLD, 24));
        g.drawString(number, 5 , 25);

        resp.setContentType("image/jpeg");
        try (OutputStream out = resp.getOutputStream()) {
            ImageIO.write(image, "jpeg", out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getNumber(int size) {

        String str = "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789";

        String number = "";
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            char c = str.charAt(r.nextInt(str.length()));
            number = number + c;
        }
        return number;

    }

}
