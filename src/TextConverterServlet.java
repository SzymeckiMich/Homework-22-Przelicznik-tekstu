import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/converter")
public class TextConverterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String text = request.getParameter("text");

        response.getWriter().println(String.format("<h1>Ilość znaków: %d</h1>", textLengthWithSpaces(text)));
        response.getWriter().println(String.format("<h1>Ilośc znaków (bez spacji): %d</h1>", textLengthWithoutSpaces(text)));
        response.getWriter().println(String.format("<h1>Ilość słów: %d </h1>", numberOfWordsInText(text)));
        if(checkStringIsPalindrome(text)){
            response.getWriter().println("<h1>Tekst jest palindromem</h1>");
        }
        else{
            response.getWriter().println("<h1>Tekst nie jest palindromem</h1>");
        }
    }



    private static int textLengthWithSpaces(String text) {
        return text.length();
    }

    private static int textLengthWithoutSpaces(String text) {
        return text.replaceAll(" ", "").length();
    }

    private static int numberOfWordsInText(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    private static boolean checkStringIsPalindrome(String text) {
        char[] charsArray = text.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] != charsArray[charsArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
