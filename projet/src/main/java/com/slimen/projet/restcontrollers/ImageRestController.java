package com.slimen.projet.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.slimen.projet.entities.Image;
import com.slimen.projet.entities.Projet;
import com.slimen.projet.service.ImageService;
import com.slimen.projet.service.ProjetService;

@RestController
@RequestMapping("api/image")
@CrossOrigin(origins="*")

public class ImageRestController {
	 @Autowired
	 ImageService imageService;
	 @Autowired
	 ProjetService projetService;
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);}

	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uploadImage(file);}

	 @PostMapping("/upload")
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uploadImage(file);}

	 @GetMapping("/get/info/{id}")
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;}

	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException{

	 return imageService.getImage(id);}
	 @PostMapping(value = "/uplaodImageProj/{idProj}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idProj") Long idProj)
	throws IOException {
	 return imageService.uplaodImageProj(file,idProj);
	 }
	@RequestMapping(value = "/getImagesProd/{idProj}" ,method = RequestMethod.GET)
	 public List<Image> getImagesProj(@PathVariable("idProj") Long idProd)
	throws IOException {
	 return imageService.getImagesParProd(idProd);
	 }
	/*
	@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile
	file,@PathVariable("id") Long id) throws IOException {
	 Projet p = projetService.getProjet(id);
	 p.setImagePath(id+".jpg");

	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
	, file.getBytes());
	projetService.saveProjet(p);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" ,
	 method = RequestMethod.GET,
	 produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Projet p = projetService.getProjet(id);
		 return
		Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	}*/


}
