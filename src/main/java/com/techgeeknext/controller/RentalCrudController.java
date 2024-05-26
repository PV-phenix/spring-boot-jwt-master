package com.techgeeknext.controller;

import com.techgeeknext.model.Rental;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping({ "/rentals" })
public class RentalCrudController {

	private List<Rental> rentals = createList();

	@GetMapping(produces = "application/json")
	public List<Rental> firstPage() {
		return rentals;
	}

	@DeleteMapping(path = { "/{id}" })
	public Rental delete(@PathVariable("id") int id) {
		Rental deletedRental = null;
		for (Rental rental : rentals) {
			if (rental.getRentalId().equals(id)) {
				rentals.remove(rental);
				deletedRental = rental;
				break;
			}
		}
		return deletedRental;
	}

	@PostMapping
	public Rental create(@RequestBody Rental user) {
		rentals.add(user);
		return user;
	}

	private static List<Rental> createList() {
		List<Rental> tempRentals = new ArrayList<>();
		Rental rental1 = new Rental();
		rental1.setName("rental1");
		rental1.setDesignation("Maison avec jardin");
		rental1.setRentalId("1");
		rental1.setPrix(3000);

		Rental rental2 = new Rental();
		rental2.setName("rental2");
		rental2.setDesignation("Appartement avec terrasse");
		rental2.setRentalId("2");
		rental2.setPrix(3000);
		tempRentals.add(rental1);
		tempRentals.add(rental2);
		return tempRentals;
	}

}