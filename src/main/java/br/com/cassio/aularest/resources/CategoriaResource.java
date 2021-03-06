package br.com.cassio.aularest.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cassio.aularest.domain.Categoria;
import br.com.cassio.aularest.services.CategoriaService;

@RestController
@RequestMapping("/categorias")

public class CategoriaResource {
	       @Autowired
	        private CategoriaService categoriaService;
             @GetMapping("/{id}") 
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
            	 
            	 Categoria categoria = categoriaService.find(id);
   
          return ResponseEntity.ok().body(categoria);
             }

             @PostMapping() 
   public  ResponseEntity<Void>  insert(@RequestBody Categoria categoria){ 
  categoria = categoriaService.insert(categoria);      
  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
  return ResponseEntity.created(uri).build();
         }
             @PutMapping("/{id}")
             public  ResponseEntity<Void> update(@RequestBody Categoria categoria ,  @PathVariable Integer id){

            	 categoria.setId(id);
            	 categoria = categoriaService.update(categoria);
            	 return ResponseEntity.noContent().build();
             }          

             @DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Integer id) {
categoriaService.delete(id);
return  ResponseEntity.noContent().build();
             }
             
}




