package src.domingo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class PagamentoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PagamentoApplication.class, args);
    }
}

interface PagamentoStrategy {
    void processar(double valor);
    String getTipo();
}

@Component
class PagamentoPix implements PagamentoStrategy {
    public void processar(double valor) { System.out.println("PIX: " + valor); }
    public String getTipo() { return "PIX"; }
}

@Component
class PagamentoCartao implements PagamentoStrategy {
    public void processar(double valor) { System.out.println("Cartão: " + valor); }
    public String getTipo() { return "CARTAO"; }
}

@Service
class PagamentoService {
    private final Map<String, PagamentoStrategy> estrategias;

    public PagamentoService(List<PagamentoStrategy> lista) {
        this.estrategias = lista.stream()
                .collect(Collectors.toMap(PagamentoStrategy::getTipo, e -> e));
    }

    public String executar(String tipo, double valor) {
        PagamentoStrategy e = estrategias.get(tipo.toUpperCase());
        if (e == null) return "Erro: Tipo invalido";
        e.processar(valor);
        return "Sucesso: " + tipo;
    }
}

@RestController
class PagamentoController {
    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping("/pagar")
    public String realizarPagamento(@RequestParam(name = "tipo") String tipo,
                                    @RequestParam(name = "valor") double valor) {
        return service.executar(tipo, valor);
    }
}