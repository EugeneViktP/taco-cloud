package sia.taco_cloud.web;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.taco_cloud.data.OrderRepository;
import sia.taco_cloud.domain.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public  String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return  "orderForm";
        }

//        try {
//            orderRepo.save(order);
//            log.info("Order submitted: {}", order);
//        } catch (DataAccessException e) {
//            log.error("Failed to save order: {}", order, e);
//            throw e; // или вернуть страницу с ошибкой
//        }

        log.debug("Attempting to save order: {}", order);
        orderRepo.save(order);

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
