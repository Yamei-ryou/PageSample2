package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Omikuji")
public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 今日の日付
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");

        // ランダムに結果を選択
        String[] results = { "大吉", "中吉", "小吉", "凶" };
        String[] messages = {
                "今日は最高の運勢！🐱",
                "落ち着いていこう🐾",
                "コツコツ積み重ねが大事にゃ",
                "逆風だけど、焦らないでにゃ"
        };

        Random rnd = new Random();
        int index = rnd.nextInt(results.length);

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'>");
        out.println("<title>おみくじ結果</title></head>");
        out.println("<body style='text-align:center; font-size:26px; padding-top:50px;'>");

        out.println("<h2>🐱 おみくじ結果発表 🐱</h2>");
        out.println("<p>" + sdf.format(now) + " の運勢は……</p>");

        out.println("<h1>" + results[index] + " !!!</h1>");
        out.println("<p>" + messages[index] + "</p>");

        out.println("<br><br>");
        out.println("<form action='index.html' method='get'>");
        out.println("<button type='submit'>戻る</button>");
        out.println("</form>");

        out.println("</body></html>");
    }
}