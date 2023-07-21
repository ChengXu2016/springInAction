package tacos.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tacos.data.IngredientRepository;
import tacos.pojo.Ingredient;

@RestController
@RequestMapping(value = "/api/ingredient", produces = "application/json")
public class IngredientController {

    private IngredientRepository ingredientRepo;


    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepo = ingredientRepository;
    }

    @GetMapping
    public Iterable<Ingredient> findAllIngredient() {
        return ingredientRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteIngredient(@PathVariable("id") String ingredientId) {
        ingredientRepo.deleteById(ingredientId);
    }
}
