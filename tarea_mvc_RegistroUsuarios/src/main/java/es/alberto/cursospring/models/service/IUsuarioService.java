package es.alberto.cursospring.models.service;

import java.util.List;

import es.alberto.cursospring.vo.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();

    public Usuario findById(Long userId);

    public void save(Usuario usuario);

    public void delete(Usuario usuario);
    
}
