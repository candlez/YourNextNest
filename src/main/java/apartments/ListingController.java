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
public class ListingController {
    private final ListingRepository repository;
    private final ListingModelAssembler assembler;

    public ListingController(ListingRepository repo, ListingModelAssembler assembler) {
        this.repository = repo;
        this.assembler = assembler;
    }

    @CrossOrigin
    @GetMapping("/listings")
    public CollectionModel<EntityModel<Listing>> all() {
        List<EntityModel<Listing>> listings = this.repository.findAll().stream()
            .map(this.assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(listings, linkTo(methodOn(ListingController.class).all()).withSelfRel());
    }

    @CrossOrigin
    @PostMapping("/listings")
    public EntityModel<Listing> newListing(Listing newListing) {
        Listing listing = repository.save(newListing);
        return this.assembler.toModel(listing);
    }

    @CrossOrigin
    @GetMapping("/listings/{id}")
    public EntityModel<Listing> one(@PathVariable Long id) {
        Listing listing = this.repository.findById(id)
            .orElseThrow(() -> new ListingNotFoundException(id));

        return this.assembler.toModel(listing);
    }

    @CrossOrigin
    @PutMapping("/listings/{id}")
    public EntityModel<Listing> replaceListing(@RequestBody Listing newListing, @PathVariable Long id) {
        return this.repository.findById(id).map(listing -> {
            listing.setName(newListing.getName());
            listing.setAddress(newListing.getAddress());
            listing.setBedrooms(newListing.getBedrooms());
            listing.setRent(newListing.getRent());
            return this.assembler.toModel(this.repository.save(listing));
        }).orElseGet(() -> {
            newListing.setId(id);
            return this.assembler.toModel(this.repository.save(newListing));
        });
    }

    @CrossOrigin
    @DeleteMapping("listings/{id}")
    public void deleteTenant(@PathVariable Long id) {
        this.repository.deleteById(id);
    }
}
