package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.bainding.Passenger;
import in.ashokit.bainding.Ticket;
import in.ashokit.service.MakeMyTripService;
import reactor.core.publisher.Mono;

@Controller
public class MakeMyTripController {

    @Autowired
    private MakeMyTripService makeMyTripService;

    @GetMapping("/")
    public String HomePage(Model model) {
    	
    	return "home";
    } 	
    @GetMapping("/train")
    public String showHomePage(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "index";
    } 	

    @PostMapping("/bookTicket")
    public String bookTicket(Passenger passenger, Model model) {
        Mono<Ticket> bookTicket = makeMyTripService.bookTicket(passenger);
        bookTicket.subscribe();
        model.addAttribute("msg", "Ticket Book Successfully...");
        return "redirect:/train";
    }
    
    
    @GetMapping("/tickets")
    public Mono<String> getAllTickets(Model model) {
        return makeMyTripService.getAllTickets()
                .doOnNext(tickets -> model.addAttribute("tickets", tickets))
                .then(Mono.just("data"));
    }
    

    @GetMapping("/cancelTicket")
    public String showCancelForm() {
        return "cancel";  
    } 

    @PostMapping("/cancelTicket")  
    public Mono<String> cancelTicket(@RequestParam("ticketId") Integer ticketId, Model model) {
        return makeMyTripService.cancelTicket(ticketId)
                .thenReturn("redirect:/cancel-success")
                .onErrorResume(e -> {
                    model.addAttribute("msg", "Ticket with ID " + ticketId + " not found.");
                    return Mono.just("cancel"); 
                });
    }

    @GetMapping("/cancel-success")
    public String cancellationSuccess(Model model) {
        model.addAttribute("message", "Ticket successfully canceled.");
        return "cancel-success"; 
    }
    
    @GetMapping("/admin")
    public String adminPanel(Model model) {
        
        return "admin";
    }
    
    @GetMapping("/about")
    public String aboutPage(Model model) {
        
        return "about";
    }
    
    @GetMapping("/contact")
    public String contactPage(Model mode) {
    	
    	return "contact";
    }
    
    @GetMapping("/explore")
    public String explorePage(Model mode) {
    	
    	return "explore";
    }
}
