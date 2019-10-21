package pl.tom.springboottestapp.securityExample;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationApi {

    private List<Quotation> quotationList;

    public QuotationApi() {
        this.quotationList = new ArrayList<>();
        quotationList.add(new Quotation("To, że milczę, nie znaczy, że nie mam nic do powiedzenia.", "Jonathan Carroll"));
        quotationList.add(new Quotation("Kocha się za nic. Nie istnieje żaden powód do miłości.", "Paulo Coelho "));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotationList() {
        return quotationList;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotationList.add(quotation);
    }

    @DeleteMapping("/api")
    public void deleteQuotation(@RequestParam int index) {
        quotationList.remove(index);
    }
}
