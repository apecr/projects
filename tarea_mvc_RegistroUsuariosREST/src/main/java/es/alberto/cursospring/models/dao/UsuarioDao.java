package es.alberto.cursospring.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.alberto.cursospring.vo.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) hibernateTemplate.find("from Usuario ");
	}

	@Override
	public Usuario findById(Long userId) {
		return hibernateTemplate.get(Usuario.class, userId);
	}

	@Override
	public void save(Usuario usuario) {
		hibernateTemplate.saveOrUpdate(usuario);

	}

	@Override
	public void delete(Usuario usuario) {
		hibernateTemplate.delete(usuario);

	}

}
