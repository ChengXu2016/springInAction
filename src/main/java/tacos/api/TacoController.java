package tacos.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.data.TacoRepository;
import tacos.po.TacoPO;

@RestController
@RequestMapping(value = "/api/tacos", produces = "application/json")
public class TacoController {

    private TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping
    public Iterable<TacoPO> queryAllTaco() {
        return tacoRepository.findAll();
    }
}
