package apartments;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;


@RestController
public class TenantController {
    private final TenantRepository repository;
    private final TenantModelAssembler assembler;

    public TenantController(TenantRepository repo, TenantModelAssembler assembler) {
        this.repository = repo;
        this.assembler = assembler;
    }

    @CrossOrigin
    @GetMapping("/tenants")
    public CollectionModel<EntityModel<Tenant>> all() {
        List<EntityModel<Tenant>> tenants = this.repository.findAll().stream()
            .map(this.assembler::toModel)
            .collect(Collectors.toList());
        
        return CollectionModel.of(tenants, linkTo(methodOn(TenantController.class).all()).withSelfRel());
    }

    @CrossOrigin
    @PostMapping("/tenants")
    public EntityModel<Tenant> newTenant(@RequestBody Tenant newTenant) {
        Tenant tenant = repository.save(newTenant);
        return this.assembler.toModel(tenant);
    }

    @CrossOrigin
    @GetMapping("/tenants/{id}")
    public EntityModel<Tenant> one(@PathVariable Long id) {
        Tenant tenant = this.repository.findById(id)
            .orElseThrow(() -> new TenantNotFoundException(id));
        
        return this.assembler.toModel(tenant);
    }

    @CrossOrigin
    @PutMapping("/tenants/{id}")
    public EntityModel<Tenant> replaceTenant(@RequestBody Tenant newTenant, @PathVariable Long id) {
        return this.repository.findById(id).map(tenant -> {
            tenant.setName(newTenant.getName());
            return this.assembler.toModel(repository.save(tenant));
        }).orElseGet(() -> {
            newTenant.setId(id);
            return this.assembler.toModel(repository.save(newTenant));
        });
        
    }

    @CrossOrigin
    @DeleteMapping("/tenants/{id}")
    public void deleteTenant(@PathVariable Long id) {
        this.repository.deleteById(id);
    }
}
