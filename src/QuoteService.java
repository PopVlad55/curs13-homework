import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuoteService {
    private List<Quote> quotes;

    public QuoteService(List<Quote> quotes){
        this.quotes = quotes;
    }
    public List<String> getAllQuotes(){
        return quotes.stream().map(Quote::getQuote).collect(Collectors.toList());
    }
    public List<String> getQuotesForAuthor(String author){
        return quotes.stream().filter(quote -> quote.getAuthor().equals(author)).map(Quote::getQuote).collect(Collectors.toList());
    }
    public List<String> getAuthors(){
        return quotes.stream().map(Quote::getAuthor).distinct().collect(Collectors.toList());
    }
    public void setFavourite(int id){
       quotes.stream().filter(quote -> quote.getId() == id).findFirst().ifPresent(quote -> quote.setFavourite(true));
    }
    public List<String> getFavourite() {
        return quotes.stream().filter(Quote::isFavourite).map(Quote::getQuote).collect(Collectors.toList());
    }


    public String getRandomQuote(){
        Random random = new Random();
        int randomId = random.nextInt(quotes.size()) + 1;
        return quotes.stream().filter(quote -> quote.getId() == randomId).findFirst().map(Quote::getQuote).orElse("");
    }
}
