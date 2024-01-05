import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Quote> quoteList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("quotes.txt"))){
            String line;
            int id = 1;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("~");
                if(parts.length == 2){
                    Quote quote = new Quote(id++, parts[0], parts[1]);
                    quoteList.add(quote);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        QuoteService quoteService = new QuoteService(quoteList);
        System.out.println("[ALL QUOTES]: " + quoteService.getAllQuotes());
        System.out.println("[QUOTES FROM BENJAMIN FRANKLIN]: " + quoteService.getQuotesForAuthor("Benjamin Franklin"));
        System.out.println("[AUTHORS]: " + quoteService.getAuthors());
        int randomId = 2;
        quoteService.setFavourite(randomId);
        System.out.println("[FAVOURITES]: " + quoteService.getFavourite());
        System.out.println("[RANDOM QUOTE]: " + quoteService.getRandomQuote());
    }
}
