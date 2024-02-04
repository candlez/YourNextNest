package apartments;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ListingModelAssembler implements RepresentationModelAssembler<Listing, EntityModel<Listing>> {
    @Override
    public EntityModel<Listing> toModel(Listing listing) {
        return EntityModel.of(
            listing,
            linkTo(methodOn(ListingController.class).one(listing.getId())).withSelfRel(),
            linkTo(methodOn(ListingController.class).all()).withRel("listings")
        );
    }
}
