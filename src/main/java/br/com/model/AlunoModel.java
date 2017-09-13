package br.com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.core.GenericModel;
import br.com.entity.AlunoEntity;

@Repository
@Transactional
public class AlunoModel extends GenericModel<AlunoEntity> {
	
	@SuppressWarnings("unchecked")
	public AlunoEntity getByCpf(String cpf) {
		List<AlunoEntity> alunos = super.getSession()
	 .createQuery("from AlunoEntity a LEFT JOIN FETCH a.matricula mt "
				+ "LEFT JOIN FETCH mt.displinas disc "
				+ "WHERE a.cpf = :cpf")
				.setParameter("cpf", cpf).list();
		
		if(alunos.size() == 1)
			return alunos.get(0); 
		else
			return alunos.get(0); 
				
	}
	
}