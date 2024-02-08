package com.example.media;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medias")
public class MediaController {
    private MediaRepository mediaRepository;
    @Autowired
    private MediaService mediaService;


    @PostMapping("/add-media")  // Utiliser l'annotation @PostMapping pour les requêtes POST
    public Media addMedia(@RequestBody Media media) {
        return mediaService.save(media);  // Sauvegarder et retourner le media sauvegardé
    }

    @PutMapping("/update-media/{id}")
    public Media updateMediaByID(@RequestBody Media updatedMedia, @PathVariable("id") Long idMedia) {
        // Utilisez findById() pour obtenir l'utilisateur existant
        return mediaRepository.findById(idMedia)
                .map(existingMedia -> {
                    // Mettre à jour les champs du media existant avec les valeurs du media mis à jour
                    existingMedia.setNomMedia(updatedMedia.getNomMedia());
                    existingMedia.setTypeMedia(updatedMedia.getTypeMedia());
                    existingMedia.setEmail(updatedMedia.getEmail());
                    // Enregistrez le media mis à jour
                    return mediaRepository.save(existingMedia);
                })
                .orElse(null);  // Si le media avec l'ID donné n'est pas trouvé, retournez null
    }

    @DeleteMapping("/{id}")  // Utiliser l'annotation @DeleteMapping pour les requêtes DELETE
    public void deleteMedia(@PathVariable("id") long id) {
        // Utilisez la méthode deleteById() du UserRepository pour supprimer le media
          mediaService.deleteById(id);
    }

    @GetMapping("/retrieve-media/{id}")
    public Media retrieveMedia(@PathVariable("id") Long mediaId) {
        // Utilisez findById() pour obtenir le media par son ID
        return mediaRepository.findById(mediaId).orElse(null);
    }
    @GetMapping("/retrieve-all")
    public ResponseEntity<List<Media>> retrieveAllMedia() {
        List<Media> medias = mediaService.retrieveAllMedias();
        return new ResponseEntity<>(medias, HttpStatus.OK);
    }

    @GetMapping("/{id}/qr-code")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Long id) {
        Media media = mediaRepository.findById(id).orElse(null);
        byte[] qrCode = mediaService.generateQRCode(media);

        if (qrCode != null) {
            return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=qr-code.png").body(qrCode);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
