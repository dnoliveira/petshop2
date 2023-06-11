package br.cefet.dbf.petshop.controller;

import java.util.List;

import br.cefet.dbf.petshop.model.Pet;
import br.cefet.dbf.petshop.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/v1/pet")
public class PetController {

  private final Logger log = LoggerFactory.getLogger(PetController.class);

  private final PetService petService;

  public PetController(PetService petService){
    this.petService = petService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pet> get(@PathVariable Long id) {
    log.info("REST request to get Pet : {}", id);
    Pet p = petService.findOne(id);

    if (p != null){
      return ResponseEntity.ok().body(p);
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping({"/",""})
  public List<Pet> getAll(){
    return petService.findAllList();
  }

  @PutMapping({"/", ""})
  public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
    log.info("REST request to update Pet : {}", pet);
    if (pet.getId() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Pet id null");
    }
    Pet p = petService.save(pet);
    return ResponseEntity.ok().body(p);
  }

  @PostMapping({"/", ""})
  public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
    log.info("REST request to save Pet : {}", pet);
    if (pet.getId() != null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Um novo pet não pode ter um ID informado");
    }
    Pet p = petService.save(pet);
    //return ResponseEntity.created(new URI("/api/pets/" + p.getId())).body(p);
    return ResponseEntity.ok().body(p);
  }

  /*
  @PostMapping(value = "/csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public List<Pet> upload(@RequestPart("data") MultipartFile csv) throws IOException {
    List<Pet> savedNotes = new ArrayList<>();
    List<Pet> notes = new BufferedReader(
        new InputStreamReader(Objects.requireNonNull(csv).getInputStream(), StandardCharsets.UTF_8)).lines()
        .map(Pet::parseNote).collect(Collectors.toList());
    petService.saveAll(notes).forEach(savedNotes::add);
    return savedNotes;
  }
  */

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePet(@PathVariable Long id) {
    log.info("REST request to delete Pet : {}", id);

    petService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
