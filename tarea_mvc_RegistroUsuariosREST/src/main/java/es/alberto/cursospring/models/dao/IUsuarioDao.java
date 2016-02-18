package es.alberto.cursospring.models.dao;

import java.util.List;

import es.alberto.cursospring.vo.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario> findAll();

    public Usuario findById(Long userId);

    public void save(Usuario usuario);

    public void delete(Usuario usuario);

}
