package br.com.cassio.aularest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cassio.aularest.domain.Categoria;
import br.com.cassio.aularest.repositories.CategoriaRepository;
import br.com.cassio.aularest.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
    @Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
	
		
return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id 
		+ "Tipo:" + Categoria.class.getName()));
				
 }


public Categoria insert(Categoria categoria) {
	categoria.setId(null);
	return categoriaRepository.save(categoria);
}
public Categoria update (Categoria categoria) {
	find(categoria.getId());
	return categoriaRepository.save(categoria);
}
 public void delete(Integer id) {
	 find(id);
	 categoriaRepository.deleteById(id);
	 
 }

}