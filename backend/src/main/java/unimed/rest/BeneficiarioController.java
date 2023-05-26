package unimed.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import unimed.model.entity.Beneficiario;
import unimed.model.repository.BeneficiarioRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
@CrossOrigin("http://localhost:4200")
public class BeneficiarioController {

    private final BeneficiarioRepository repository;
    @Autowired
    public BeneficiarioController(BeneficiarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Beneficiario> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiario salvar (@RequestBody @Valid Beneficiario beneficiario){
        return repository.save(beneficiario);
    }

    @GetMapping("{id}")
    public Beneficiario acharPorId( @PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map( beneficiario -> {
                    repository.delete(beneficiario);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody Beneficiario beneficiarioAtualizado ){
        repository
                .findById(id)
                .map( beneficiario -> {
                    beneficiarioAtualizado.setId(beneficiario.getId());
                    return repository.save(beneficiarioAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
