package apartments;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TenantModelAssembler implements RepresentationModelAssembler<Tenant, EntityModel<Tenant>> {
    @Override
    public EntityModel<Tenant> toModel(Tenant tenant) {
        return EntityModel.of(
            tenant,
            linkTo(methodOn(TenantController.class).one(tenant.getId())).withSelfRel(),
            linkTo(methodOn(TenantController.class).all()).withRel("tenants")
        );
    }
}
