package dev.tobiadegbuji.artistpersistenceservice.controller;

import dev.tobiadegbuji.artistpersistenceservice.dto.ArtistDto;
import dev.tobiadegbuji.artistpersistenceservice.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/jazzified/artist")
@AllArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/{artistId}")
    public ResponseEntity<ArtistDto> retrieveArtist(@PathVariable UUID artistId) {

        ArtistDto artistDto = artistService.retrieveArtistById(artistId);

        return new ResponseEntity<>(artistDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArtistDto> createArtist(@RequestBody @Valid ArtistDto artistDto) {

        ArtistDto savedArtistDto = artistService.createArtist(artistDto);

        return new ResponseEntity<>(savedArtistDto, HttpStatus.CREATED);
    }


}
